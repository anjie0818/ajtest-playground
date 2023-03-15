package org.playground.ajtest.vo;

import com.diboot.core.binding.annotation.*;
import org.playground.ajtest.entity.AjSystem;
import com.diboot.iam.entity.IamUser;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;
import org.playground.ajtest.entity.AjTestJob;

/**
 * 被测系统 DetailVO定义
 * @author anjie
 * @version 1.0
 * @date 2023-03-09
 * Copyright © anjieCR
 */
@Getter
@Setter
@Accessors(chain = true)
public class AjSystemDetailVO extends AjSystem {

    private static final long serialVersionUID = -3556534033849030635L;

    /**
     * 关联字段 系统用户.真实姓名：IamUser.realname
     */
    @BindField(entity = IamUser.class, field = "realname", condition = "this.create_by=id")
    private String createByName;

    // 绑定ajTestJobList
    @BindEntityList(entity = AjTestJob.class, condition = "this.id=system_id")
    private List<AjTestJob> ajTestJobList;
}
