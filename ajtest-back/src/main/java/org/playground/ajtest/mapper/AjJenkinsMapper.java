package org.playground.ajtest.mapper;

import com.diboot.core.mapper.BaseCrudMapper;
import org.playground.ajtest.entity.AjJenkins;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.io.Serializable;

/**
* jenkins实例Mapper
* @author anjie
* @version 1.0
* @date 2023-03-09
 * Copyright © anjieCR
*/
@Mapper
public interface AjJenkinsMapper extends BaseCrudMapper<AjJenkins> {

}

