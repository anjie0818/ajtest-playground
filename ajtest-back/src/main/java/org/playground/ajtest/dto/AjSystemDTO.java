package org.playground.ajtest.dto;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import org.playground.ajtest.entity.AjSystem;
import com.diboot.iam.entity.IamUser;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* 被测系统 DTO定义
* @author anjie
* @version 1.0
* @date 2023-03-09
 * Copyright © anjieCR
*/
@Getter @Setter @Accessors(chain = true)
public class AjSystemDTO extends AjSystem  {
    private static final long serialVersionUID = 6983783590819877587L;

    /**
    * 关联字段 系统用户.真实姓名：IamUser.realname
    */
    @BindQuery(comparison = Comparison.EQ, entity = IamUser.class, field = "realname", condition = "this.create_by=id")
    private String createByName;
}