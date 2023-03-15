package org.playground.ajtest.entity;

import java.util.Date;
import java.lang.Double;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import org.playground.ajtest.entity.BaseCustomEntity;
import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import com.diboot.core.util.D;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* jenkins实例 Entity定义
* @author anjie
* @version 1.0
* @date 2023-03-09
* Copyright © anjieCR
*/
@Getter @Setter @Accessors(chain = true)
@TableName("aj_jenkins")
public class AjJenkins extends BaseCustomEntity {
    private static final long serialVersionUID = -1882816316171189081L;

    /**
    * 实例名称 
    */
    @NotNull(message = "实例名称不能为空")
    @Length(max=100, message="实例名称长度应小于100")
    @BindQuery(comparison = Comparison.LIKE)
    @TableField()
    private String name;

    /**
    * 实例地址 
    */
    @NotNull(message = "实例地址不能为空")
    @Length(max=100, message="实例地址长度应小于100")
    @TableField()
    private String jenkinsUrl;

    /**
    * jenkins账号 
    */
    @Length(max=100, message="jenkins账号长度应小于100")
    @TableField()
    private String jenkinsUsername;

    /**
    * jenkinkToken 
    */
    @Length(max=100, message="jenkinkToken长度应小于100")
    @TableField()
    private String jenkinsToken;

    /**
    * 备注 
    */
    @Length(max=100, message="备注长度应小于100")
    @TableField()
    private String remarks;

    /**
    * 创建人 
    */
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    /**
    * 更新人 
    */
    @TableField(fill = FieldFill.UPDATE)
    private Long updateBy;

    /**
    * 更新时间 
    */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;


} 
