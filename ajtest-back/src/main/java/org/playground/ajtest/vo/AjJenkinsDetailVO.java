package org.playground.ajtest.vo;

import com.diboot.core.binding.annotation.*;
import org.playground.ajtest.entity.AjJenkins;
import com.diboot.iam.entity.IamUser;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
* jenkins实例 DetailVO定义
* @author anjie
* @version 1.0
* @date 2023-03-09
 * Copyright © anjieCR
*/
@Getter @Setter @Accessors(chain = true)
public class AjJenkinsDetailVO extends AjJenkins  {
    private static final long serialVersionUID = 6464358654047431923L;

    /**
    * 关联字段 系统用户.真实姓名：IamUser.realname 
    */
    @BindField(entity = IamUser.class, field = "realname", condition = "this.create_by=id")
    private String createByName;

    /**
    * 关联字段 系统用户.真实姓名：IamUser.realname 
    */
    @BindField(entity = IamUser.class, field = "realname", condition = "this.update_by=id")
    private String updateByName;

}