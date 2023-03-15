package org.playground.ajtest.vo;

import com.diboot.core.binding.annotation.*;
import org.playground.ajtest.entity.AjTestJob;
import org.playground.ajtest.entity.AjSystem;
import com.diboot.iam.entity.IamUser;
import org.playground.ajtest.entity.AjJenkins;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
* 测试任务 ListVO定义
* @author anjie
* @version 1.0
* @date 2023-03-09
 * Copyright © anjieCR
*/
@Getter @Setter @Accessors(chain = true)
public class AjTestJobListVO extends AjTestJob  {
    private static final long serialVersionUID = -35383251829395636L;

    /** 
    * 关联字段 系统名称：AjSystem.name
    */
    @BindField(entity = AjSystem.class, field = "name", condition = "this.system_id=id")
    private String ajSystemName;

    /** 
    * 关联字典：TEST_TYPE
    */
    @BindDict(type=DICT_TEST_TYPE, field="type")
    private String typeLabel;

    /** 
    * 关联字典：TEST_MODE
    */
    @BindDict(type=DICT_TEST_MODE, field="mode")
    private String modeLabel;

    /** 
    * 关联字段 系统用户.真实姓名：IamUser.realname
    */
    @BindField(entity = IamUser.class, field = "realname", condition = "this.create_by=id")
    private String createByName;

    /** 
    * 关联字段 实例名称：AjJenkins.name
    */
    @BindField(entity = AjJenkins.class, field = "name", condition = "this.jenkins_id=id")
    private String ajJenkinsName;

    /** 
    * 关联字段 系统用户.真实姓名：IamUser.realname
    */
    @BindField(entity = IamUser.class, field = "realname", condition = "this.update_by=id")
    private String updateByName;

}