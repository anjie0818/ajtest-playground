package org.playground.ajtest.vo;

import com.diboot.core.binding.annotation.*;
import org.playground.ajtest.entity.AjTestJobHistory;
import org.playground.ajtest.entity.AjTestJob;
import com.diboot.iam.entity.IamUser;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
* 执行历史 ListVO定义
* @author anjie
* @version 1.0
* @date 2023-03-09
 * Copyright © anjieCR
*/
@Getter @Setter @Accessors(chain = true)
public class AjTestJobHistoryListVO extends AjTestJobHistory  {
    private static final long serialVersionUID = 8852691805833536749L;

    /** 
    * 关联字段 任务名称：AjTestJob.name
    */
    @BindField(entity = AjTestJob.class, field = "name", condition = "this.test_job_id=id")
    private String ajTestJobName;

    /** 
    * 关联字段 系统用户.真实姓名：IamUser.realname
    */
    @BindField(entity = IamUser.class, field = "realname", condition = "this.create_by=id")
    private String createByName;

}