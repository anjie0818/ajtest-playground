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
* 被测系统 Entity定义
* @author anjie
* @version 1.0
* @date 2023-03-09
* Copyright © anjieCR
*/
@Getter @Setter @Accessors(chain = true)
@TableName("aj_system")
public class AjSystem extends BaseCustomEntity {
    private static final long serialVersionUID = -7438471413288066392L;

    /**
    * 系统名称 
    */
    @NotNull(message = "系统名称不能为空")
    @Length(max=100, message="系统名称长度应小于100")
    @BindQuery(comparison = Comparison.LIKE)
    @TableField()
    private String name;

    /**
    * 描述 
    */
    @Length(max=100, message="描述长度应小于100")
    @TableField()
    private String des;

    /**
    * 创建人 
    */
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;


} 
