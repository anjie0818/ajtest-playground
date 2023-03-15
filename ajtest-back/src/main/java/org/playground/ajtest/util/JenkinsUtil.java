package org.playground.ajtest.util;



import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.common.IntegerResponse;
import com.cdancy.jenkins.rest.domain.common.RequestStatus;
import com.cdancy.jenkins.rest.domain.job.BuildInfo;
import com.cdancy.jenkins.rest.domain.job.JobInfo;
import com.cdancy.jenkins.rest.domain.queue.QueueItem;
import com.cdancy.jenkins.rest.domain.system.SystemInfo;
import com.cdancy.jenkins.rest.features.JobsApi;
import org.playground.ajtest.entity.AjTestJobHistory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author tlibn
 * @Date 2020/8/11 15:21
 **/
public class JenkinsUtil {

    public static void build(AjTestJobHistory ajTestJobHistory) throws IOException, URISyntaxException, InterruptedException {

        //获取参数
        String jenkinsUrl = ajTestJobHistory.getJenkinsUrl();
        String jenkinsUserName = ajTestJobHistory.getJenkinsUsername();
        String jenkinsToken = ajTestJobHistory.getJenkinsToken();

        String jobJenkinsFile = ajTestJobHistory.getJobJenkinsFile();

        //拼装Jenkins job名称
        String jobName = ajTestJobHistory.getJenkinsJobName();

        //调用jenkins触发job执行
        JenkinsClient client = JenkinsClient.builder()
                .endPoint(jenkinsUrl) // Optional. Defaults to http://127.0.0.1:8080
                .credentials(jenkinsUserName+":"+jenkinsToken) // Optional.
                .build();
        System.out.println("--------systemInfo--------"+client.api().systemApi().systemInfo());
        String configStr = getJobXml("JenkinsConfigDir/config-default.xml");
        configStr = configStr.replace("${jobJenkinsFile}",jobJenkinsFile);
        if (client.api().jobsApi().jobInfo(null, jobName)==null){
            client.api().jobsApi().create(null,jobName,configStr);
        }else {
            client.api().jobsApi().config(null, jobName, configStr);
        }
        IntegerResponse queueId = client.api().jobsApi().build(null, jobName);

        QueueItem queueItem = client.api().queueApi().queueItem(queueId.value());
        while (true) {
            if (queueItem.cancelled()) {
                throw new RuntimeException("Queue item cancelled");
            }
            if (queueItem.executable()!=null) {
                System.out.println("Build is executing with build number: " + queueItem.executable().number());
                break;
            }
            Thread.sleep(100);
            System.out.println("build----"+jobName+"---查询---构建编号");
            queueItem = client.api().queueApi().queueItem(queueId.value());
        }
        // Get the build info of the queue item being built and poll until it is done
        BuildInfo buildInfo = client.api().jobsApi().buildInfo(null, jobName, queueItem.executable().number());
        ajTestJobHistory.setJenkinsBuildNum(buildInfo.id());
        ajTestJobHistory.setExecuteStatus(buildInfo.building()==true?"BUILDING":"");

    }

    public static String getJobXml(String path) throws IOException {

        ClassPathResource classPathResource = new ClassPathResource(path);
        InputStream inputStream = classPathResource.getInputStream();

        String jobConfigXml = FileUtil.getText(inputStream);

        return jobConfigXml;

    }

    /**
     * 获取jenkins结果
     */
    public static void callback(AjTestJobHistory ajTestJobHistory){
        //获取参数
        String jenkinsUrl = ajTestJobHistory.getJenkinsUrl();
        String jenkinsUserName = ajTestJobHistory.getJenkinsUsername();
        String jenkinsToken = ajTestJobHistory.getJenkinsToken();

        String jobJenkinsFile = ajTestJobHistory.getJobJenkinsFile();

        //拼装Jenkins job名称
        String jobName = ajTestJobHistory.getJenkinsJobName();

        //调用jenkins触发job执行
        JenkinsClient client = JenkinsClient.builder()
                .endPoint(jenkinsUrl) // Optional. Defaults to http://127.0.0.1:8080
                .credentials(jenkinsUserName+":"+jenkinsToken) // Optional.
                .build();

        // Get the build info of the queue item being built and poll until it is done
        BuildInfo buildInfo = client.api().jobsApi().buildInfo(null, jobName, Integer.parseInt(ajTestJobHistory.getJenkinsBuildNum()));
        while (buildInfo.result() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            buildInfo = client.api().jobsApi().buildInfo(null, jobName, Integer.parseInt(ajTestJobHistory.getJenkinsBuildNum()));
            System.out.println("callback----"+jobName+"-----"+buildInfo);
        }
        ajTestJobHistory.setExecuteStatus(buildInfo.result());
        ajTestJobHistory.setSpendTime(String.valueOf(buildInfo.duration()));
        ajTestJobHistory.setJenkinsBuildReportUrl(buildInfo.url());
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        JenkinsClient client = JenkinsClient.builder()
                .endPoint("http://127.0.0.1:9090") // Optional. Defaults to http://127.0.0.1:8080
                .credentials("root:123456") // Optional.
                .build();
        String configStr = getJobXml("JenkinsConfigDir/config-default.xml");
        configStr = configStr.replace("${jobJenkinsFile}","pipeline {\n" +
                "    agent any\n" +
                "\n" +
                "    stages {\n" +
                "        stage('Hello') {\n" +
                "            steps {\n" +
                "                echo 'Hello World'\n" +
                "                sleep 20\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n");
        String jobName = "myjob2";
        if (client.api().jobsApi().jobInfo(null, jobName)==null){
            client.api().jobsApi().create(null,jobName,configStr);
        }else {
            client.api().jobsApi().config(null, jobName, configStr);
        }

        IntegerResponse queueId = client.api().jobsApi().build(null, jobName);

        QueueItem queueItem = client.api().queueApi().queueItem(queueId.value());
        while (true) {
            if (queueItem.cancelled()) {
                throw new RuntimeException("Queue item cancelled");
            }
            if (queueItem.executable()!=null) {
                System.out.println("Build is executing with build number: " + queueItem.executable().number());
                break;
            }
            Thread.sleep(10000);
            queueItem = client.api().queueApi().queueItem(queueId.value());
        }
        // Get the build info of the queue item being built and poll until it is done
        BuildInfo buildInfo = client.api().jobsApi().buildInfo(null, jobName, queueItem.executable().number());
        System.out.println("---buildInfo-----"+buildInfo);
        while (buildInfo.result() == null) {
            Thread.sleep(1000);
            buildInfo = client.api().jobsApi().buildInfo(null, jobName, queueItem.executable().number());
            System.out.println(buildInfo);
        }

    }

}
