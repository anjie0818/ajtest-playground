package org.playground.ajtest.vo;

import com.diboot.core.binding.annotation.*;
import org.playground.ajtest.entity.AjSystem;
import com.diboot.iam.entity.IamUser;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
* 被测系统 ListVO定义
* @author anjie
* @version 1.0
* @date 2023-03-09
 * Copyright © anjieCR
*/
@Getter @Setter @Accessors(chain = true)
public class AjSystemListVO extends AjSystem  {
    private static final long serialVersionUID = 199034873321236005L;

    /** 
    * 关联字段 系统用户.真实姓名：IamUser.realname
    */
    @BindField(entity = IamUser.class, field = "realname", condition = "this.create_by=id")
    private String createByName;

}