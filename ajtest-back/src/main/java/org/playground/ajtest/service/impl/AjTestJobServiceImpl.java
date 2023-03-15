package org.playground.ajtest.service.impl;

import com.diboot.core.util.BeanUtils;
import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.Status;
import org.playground.ajtest.entity.AjTestJob;
import org.playground.ajtest.entity.AjTestJobHistory;
import org.playground.ajtest.mapper.AjTestJobHistoryMapper;
import org.playground.ajtest.mapper.AjTestJobMapper;
import org.playground.ajtest.service.AjTestJobHistoryService;
import org.playground.ajtest.service.AjTestJobService;
import org.playground.ajtest.service.impl.BaseCustomServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.playground.ajtest.util.JenkinsUtil;
import org.playground.ajtest.vo.AjTestJobDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
* 测试任务相关Service实现
* @author anjie
* @version 1.0
* @date 2023-03-09
 * Copyright © anjieCR
*/
@Service
@Slf4j
public class AjTestJobServiceImpl extends BaseCustomServiceImpl<AjTestJobMapper, AjTestJob> implements AjTestJobService {


    @Autowired
    private AjTestJobHistoryService ajTestJobHistoryService;
    @Resource(name="threadPoolExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public JsonResult buildTestJob(Long id) throws IOException, URISyntaxException, InterruptedException {
        //查询TestJobDetailVO
        AjTestJobDetailVO ajTestJobDetailVO = this.getViewObject(id, AjTestJobDetailVO.class);
        //插入AjTestJobHistory
        AjTestJobHistory ajTestJobHistory = new AjTestJobHistory();

        ajTestJobHistory.setJenkinsUrl(ajTestJobDetailVO.getAjJenkins().getJenkinsUrl());
        ajTestJobHistory.setJenkinsUsername(ajTestJobDetailVO.getAjJenkins().getJenkinsUsername());
        ajTestJobHistory.setJenkinsToken(ajTestJobDetailVO.getAjJenkins().getJenkinsToken());

        ajTestJobHistory.setJobJenkinsFile(ajTestJobDetailVO.getJenkinsFile());
        ajTestJobHistory.setTestJobId(ajTestJobDetailVO.getId());
        ajTestJobHistory.setJenkinsJobName(ajTestJobDetailVO.getJenkinsJobName());

        JenkinsUtil.build(ajTestJobHistory);//编号+状态

        boolean success = ajTestJobHistoryService.createEntity(ajTestJobHistory);

        //花费时间+测试报告，只能异步回调
        threadPoolTaskExecutor.execute(()->{
            JenkinsUtil.callback(ajTestJobHistory);
            ajTestJobHistoryService.updateEntity(ajTestJobHistory);
        });
        if (success) {
            Map<String, Object> data = new HashMap<>();
            data.put("id",ajTestJobHistory.getId());
            return JsonResult.OK(data);
        } else {
            log.warn("创建操作未成功，entity=" + ajTestJobHistory.getClass().getSimpleName());
            return new JsonResult(Status.FAIL_OPERATION);
        }
    }
}
