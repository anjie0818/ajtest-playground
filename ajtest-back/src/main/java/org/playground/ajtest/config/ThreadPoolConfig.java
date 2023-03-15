package org.playground.ajtest.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: ThreadPoolConfig
 * @Description: 线程池配置文件
 * @author: 安杰
 * @date: 2023/3/15 13:44
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    private final Logger logger = LoggerFactory.getLogger(ThreadPoolConfig.class);


    @Bean
    public Executor threadPoolExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);//核心线程数
        threadPoolTaskExecutor.setMaxPoolSize(20);//最大线程数
        threadPoolTaskExecutor.setQueueCapacity(50);
        threadPoolTaskExecutor.setKeepAliveSeconds(300);
        threadPoolTaskExecutor.setThreadNamePrefix("threadPool_");

        // rejection-policy: 当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS: 不在新线程中执行任务，而是有调用者所在的线程来执行
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

}