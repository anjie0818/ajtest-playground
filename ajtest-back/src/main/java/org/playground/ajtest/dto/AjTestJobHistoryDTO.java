package org.playground.ajtest.dto;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import org.playground.ajtest.entity.AjTestJobHistory;
import org.playground.ajtest.entity.AjTestJob;
import com.diboot.iam.entity.IamUser;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* 执行历史 DTO定义
* @author anjie
* @version 1.0
* @date 2023-03-09
 * Copyright © anjieCR
*/
@Getter @Setter @Accessors(chain = true)
public class AjTestJobHistoryDTO extends AjTestJobHistory  {
    private static final long serialVersionUID = -7039104820373400324L;

    /**
    * 关联字段 任务名称：AjTestJob.name
    */
    @BindQuery(comparison = Comparison.EQ, entity = AjTestJob.class, field = "name", condition = "this.test_job_id=id")
    private String ajTestJobName;
    /**
    * 关联字段 系统用户.真实姓名：IamUser.realname
    */
    @BindQuery(comparison = Comparison.EQ, entity = IamUser.class, field = "realname", condition = "this.create_by=id")
    private String createByName;
}