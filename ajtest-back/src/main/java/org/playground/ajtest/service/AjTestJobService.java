package org.playground.ajtest.service;

import com.diboot.core.vo.JsonResult;
import org.playground.ajtest.entity.AjTestJob;
import org.playground.ajtest.service.BaseCustomService;

import java.io.IOException;
import java.net.URISyntaxException;

/**
* 测试任务相关Service
* @author anjie
* @version 1.0
* @date 2023-03-09
 * Copyright © anjieCR
*/
public interface AjTestJobService extends BaseCustomService<AjTestJob> {
    JsonResult buildTestJob(Long id) throws IOException, URISyntaxException, InterruptedException;
}