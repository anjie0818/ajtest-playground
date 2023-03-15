package org.playground.ajtest.service.impl;

import com.diboot.core.service.impl.BaseServiceImpl;
import com.diboot.core.mapper.BaseCrudMapper;
import org.playground.ajtest.service.BaseCustomService;
import lombok.extern.slf4j.Slf4j;
/**
* 自定义 BaseService 接口实现
* @author anjie
* @version 1.0
* @date 2023-03-08
 * Copyright © anjieCR
*/
@Slf4j
public class BaseCustomServiceImpl<M extends BaseCrudMapper<T>, T> extends BaseServiceImpl<M, T> implements BaseCustomService<T> {

}
