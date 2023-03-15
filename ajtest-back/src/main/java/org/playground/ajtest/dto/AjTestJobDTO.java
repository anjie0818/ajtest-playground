package org.playground.ajtest.dto;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import org.playground.ajtest.entity.AjTestJob;
import org.playground.ajtest.entity.AjSystem;
import com.diboot.iam.entity.IamUser;
import org.playground.ajtest.entity.AjJenkins;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 测试任务 DTO定义
 * @author anjie
 * @version 1.0
 * @date 2023-03-09
 * Copyright © anjieCR
 */
@Getter
@Setter
@Accessors(chain = true)
public class AjTestJobDTO extends AjTestJob {

    private static final long serialVersionUID = -3268180561822490801L;

    /**
     * 关联字段 系统名称：AjSystem.name
     */
    @BindQuery(comparison = Comparison.EQ, entity = AjSystem.class, field = "name", condition = "this.system_id=id")
    private String ajSystemName;

    /**
     * 关联字段 系统用户.真实姓名：IamUser.realname
     */
    @BindQuery(comparison = Comparison.EQ, entity = IamUser.class, field = "realname", condition = "this.create_by=id")
    private String createByName;

    /**
     * 关联字段 实例名称：AjJenkins.name
     */
    @BindQuery(comparison = Comparison.EQ, entity = AjJenkins.class, field = "name", condition = "this.jenkins_id=id")
    private String ajJenkinsName;

    /**
     * 关联字段 系统用户.真实姓名：IamUser.realname
     */
    @BindQuery(comparison = Comparison.EQ, entity = IamUser.class, field = "realname", condition = "this.update_by=id")
    private String updateByName;
}
