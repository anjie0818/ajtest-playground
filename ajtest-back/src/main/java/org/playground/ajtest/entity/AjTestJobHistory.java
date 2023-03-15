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
 * 执行历史 Entity定义
 * @author anjie
 * @version 1.0
 * @date 2023-03-09
 * Copyright © anjieCR
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("aj_test_job_history")
public class AjTestJobHistory extends BaseCustomEntity {

    private static final long serialVersionUID = 7192575094804772400L;

    /**
     * 实例地址
     */
    @Length(max = 100, message = "实例地址长度应小于100")
    @TableField()
    private String jenkinsUrl;

    /**
     * jenkins账号
     */
    @Length(max = 100, message = "jenkins账号长度应小于100")
    @TableField()
    private String jenkinsUsername;

    /**
     * jenkinkToken
     */
    @Length(max = 100, message = "jenkinkToken长度应小于100")
    @TableField()
    private String jenkinsToken;

    /**
     * jenkins流水线名称
     */
    @Length(max = 100, message = "jenkins流水线名称长度应小于100")
    @TableField()
    private String jenkinsJobName;

    /**
     * jenkins构建编号
     */
    @Length(max = 100, message = "jenkins构建编号长度应小于100")
    @TableField()
    private String jenkinsBuildNum;

    /**
     * jenkins构建测试报告地址
     */
    @Length(max = 100, message = "jenkins构建测试报告地址长度应小于100")
    @TableField()
    private String jenkinsBuildReportUrl;

    /**
     * 执行脚本
     */
    @Length(max = 2000, message = "执行脚本长度应小于2000")
    @TableField()
    private String jobJenkinsFile;

    /**
     * 测试任务
     */
    @TableField()
    private Long testJobId;

    /**
     * 执行状态
     */
    @Length(max = 10, message = "执行状态长度应小于10")
    @TableField()
    private String executeStatus;

    /**
     * 执行时长
     */
    @Length(max = 100, message = "执行时长长度应小于100")
    @TableField()
    private String spendTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
}
