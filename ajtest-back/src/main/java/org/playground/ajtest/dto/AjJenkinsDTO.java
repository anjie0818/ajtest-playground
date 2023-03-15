package org.playground.ajtest.dto;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import org.playground.ajtest.entity.AjJenkins;
import com.diboot.iam.entity.IamUser;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* jenkins实例 DTO定义
* @author anjie
* @version 1.0
* @date 2023-03-09
 * Copyright © anjieCR
*/
@Getter @Setter @Accessors(chain = true)
public class AjJenkinsDTO extends AjJenkins  {
    private static final long serialVersionUID = 5108571510545470584L;

    /**
    * 关联字段 系统用户.真实姓名：IamUser.realname
    */
    @BindQuery(comparison = Comparison.EQ, entity = IamUser.class, field = "realname", condition = "this.create_by=id")
    private String createByName;
    /**
    * 关联字段 系统用户.真实姓名：IamUser.realname
    */
    @BindQuery(comparison = Comparison.EQ, entity = IamUser.class, field = "realname", condition = "this.update_by=id")
    private String updateByName;
}