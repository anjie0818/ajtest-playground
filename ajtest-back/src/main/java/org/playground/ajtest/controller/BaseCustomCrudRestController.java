package org.playground.ajtest.controller;

import com.diboot.core.controller.BaseCrudRestController;
import com.diboot.core.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义通用CRUD父类RestController
 *
 * @author anjie
 * @version 1.0
 * @date 2023-03-08
 * Copyright © anjieCR
 */
@Slf4j
public class BaseCustomCrudRestController<E extends BaseEntity> extends BaseCrudRestController<E> {

}