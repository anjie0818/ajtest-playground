-- 2023-03-09 13:10:55 by anjie
CREATE TABLE `aj_test_job`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`update_by` bigint(20) NULL DEFAULT 0 COMMENT '更新人',`update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '测试任务';
-- 2023-03-09 13:12:58 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `name` char(100) NOT NULL COMMENT '测试任务名称' AFTER `is_deleted`;
-- 2023-03-09 13:12:58 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `system_id` bigint NOT NULL COMMENT '归属项目' AFTER `name`;
-- 2023-03-09 13:12:58 by anjie
CREATE INDEX idx_aj_test_job_system_id ON `aj_test_job`(system_id);
-- 2023-03-09 13:12:58 by anjie
ALTER TABLE `aj_test_job` MODIFY COLUMN `create_by` bigint DEFAULT 0 COMMENT '创建人' AFTER `system_id`;
-- 2023-03-09 13:16:47 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `type` char(100) NOT NULL COMMENT '任务类型' AFTER `system_id`;
-- 2023-03-09 13:16:47 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `mode` char(100) NOT NULL COMMENT '模式' AFTER `type`;
-- 2023-03-09 13:16:47 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `descr` varchar(100) COMMENT '描述' AFTER `mode`;
-- 2023-03-09 13:16:47 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `jenkins_file` varchar(1000) NOT NULL COMMENT '执行脚本' AFTER `descr`;
-- 2023-03-09 13:16:47 by anjie
ALTER TABLE `aj_test_job` MODIFY COLUMN `create_by` bigint DEFAULT 0 COMMENT '创建人' AFTER `jenkins_file`;
-- 2023-03-09 13:20:01 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `jenkins_id` bigint NOT NULL COMMENT '执行引擎' AFTER `descr`;
-- 2023-03-09 13:20:01 by anjie
CREATE INDEX idx_aj_test_job_jenkins_id ON `aj_test_job`(jenkins_id);
-- 2023-03-09 13:20:01 by anjie
ALTER TABLE `aj_test_job` MODIFY COLUMN `jenkins_file` varchar(1000) NOT NULL COMMENT '执行脚本' AFTER `jenkins_id`;
-- 2023-03-09 15:42:56 by anjie
CREATE TABLE `aj_jenkins`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`update_by` bigint(20) NULL DEFAULT 0 COMMENT '更新人',`update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT 'jenkins实例';
-- 2023-03-09 16:01:04 by anjie
ALTER TABLE `aj_jenkins` ADD COLUMN `name` char(100) NOT NULL COMMENT '实例名称' AFTER `is_deleted`;
-- 2023-03-09 16:01:04 by anjie
ALTER TABLE `aj_jenkins` ADD COLUMN `jenkins_url` char(100) NOT NULL COMMENT '实例地址' AFTER `name`;
-- 2023-03-09 16:01:04 by anjie
ALTER TABLE `aj_jenkins` ADD COLUMN `jenkins_username` varchar(100) COMMENT 'jenkins账号' AFTER `jenkins_url`;
-- 2023-03-09 16:01:04 by anjie
ALTER TABLE `aj_jenkins` ADD COLUMN `jenkins_token` varchar(100) COMMENT 'jenkinkToken' AFTER `jenkins_username`;
-- 2023-03-09 16:01:04 by anjie
ALTER TABLE `aj_jenkins` ADD COLUMN `remarks` varchar(100) COMMENT '备注' AFTER `jenkins_token`;
-- 2023-03-09 16:01:05 by anjie
ALTER TABLE `aj_jenkins` MODIFY COLUMN `create_by` bigint DEFAULT 0 COMMENT '创建人' AFTER `remarks`;
-- 2023-03-09 16:01:56 by anjie
CREATE TABLE `aj_system`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '被测系统';
-- 2023-03-09 16:03:37 by anjie
ALTER TABLE `aj_system` ADD COLUMN `name` char(100) NOT NULL COMMENT '系统名称' AFTER `is_deleted`;
-- 2023-03-09 16:03:37 by anjie
ALTER TABLE `aj_system` ADD COLUMN `des` char(100) COMMENT '描述' AFTER `name`;
-- 2023-03-09 16:03:37 by anjie
ALTER TABLE `aj_system` MODIFY COLUMN `create_by` bigint DEFAULT 0 COMMENT '创建人' AFTER `des`;
-- 2023-03-09 16:04:10 by anjie
CREATE TABLE `aj_test_job`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`update_by` bigint(20) NULL DEFAULT 0 COMMENT '更新人',`update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '测试任务';
-- 2023-03-09 16:11:41 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `name` char(100) NOT NULL COMMENT '任务名称' AFTER `is_deleted`;
-- 2023-03-09 16:11:41 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `system_id` bigint COMMENT '归属项目' AFTER `name`;
-- 2023-03-09 16:11:41 by anjie
CREATE INDEX idx_aj_test_job_system_id ON `aj_test_job`(system_id);
-- 2023-03-09 16:11:41 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `type` varchar(100) COMMENT '任务类型' AFTER `system_id`;
-- 2023-03-09 16:11:41 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `mode` varchar(100) COMMENT '模式' AFTER `type`;
-- 2023-03-09 16:11:41 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `des` varchar(100) COMMENT '描述' AFTER `mode`;
-- 2023-03-09 16:11:41 by anjie
ALTER TABLE `aj_test_job` MODIFY COLUMN `create_by` bigint DEFAULT 0 COMMENT '创建人' AFTER `des`;
-- 2023-03-09 16:11:41 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `jenkins_id` bigint COMMENT '执行引擎' AFTER `create_by`;
-- 2023-03-09 16:11:41 by anjie
CREATE INDEX idx_aj_test_job_jenkins_id ON `aj_test_job`(jenkins_id);
-- 2023-03-09 16:11:41 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `jenkins_file` varchar(2000) COMMENT '执行脚本' AFTER `jenkins_id`;
-- 2023-03-09 16:11:41 by anjie
ALTER TABLE `aj_test_job` MODIFY COLUMN `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' AFTER `jenkins_file`;
-- 2023-03-09 16:18:40 by anjie
ALTER TABLE `aj_test_job` ADD COLUMN `jenkins_job_name` varchar(100) COMMENT 'jenkins流水线名称' AFTER `jenkins_id`;
-- 2023-03-09 16:18:40 by anjie
ALTER TABLE `aj_test_job` MODIFY COLUMN `jenkins_file` varchar(2000) COMMENT '执行脚本' AFTER `jenkins_job_name`;
-- 2023-03-09 17:12:38 by anjie
CREATE TABLE `aj_test_job_history`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '执行历史';
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` ADD COLUMN `jenkins_url` varchar(100) COMMENT '实例地址' AFTER `is_deleted`;
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` ADD COLUMN `jenkins_username` varchar(100) COMMENT 'jenkins账号' AFTER `jenkins_url`;
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` ADD COLUMN `jenkins_token` varchar(100) COMMENT 'jenkinkToken' AFTER `jenkins_username`;
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` ADD COLUMN `jenkins_job_name` varchar(100) COMMENT 'jenkins流水线名称' AFTER `jenkins_token`;
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` ADD COLUMN `jenkins_build_num` varchar(100) COMMENT 'jenkins构建编号' AFTER `jenkins_job_name`;
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` ADD COLUMN `jenkins_build_report_url` varchar(100) COMMENT 'jenkins构建测试报告地址' AFTER `jenkins_build_num`;
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` ADD COLUMN `job_jenkins_file` varchar(2000) COMMENT 'jenkins流水线名称' AFTER `jenkins_build_report_url`;
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` ADD COLUMN `test_job_id` bigint COMMENT '测试任务' AFTER `job_jenkins_file`;
-- 2023-03-09 17:34:05 by anjie
CREATE INDEX idx_aj_test_job_history_test_job_id ON `aj_test_job_history`(test_job_id);
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` ADD COLUMN `execute_status` varchar(10) COMMENT '执行状态' AFTER `test_job_id`;
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` ADD COLUMN `spend_time` varchar(100) COMMENT '执行时长' AFTER `execute_status`;
-- 2023-03-09 17:34:05 by anjie
ALTER TABLE `aj_test_job_history` MODIFY COLUMN `create_by` bigint DEFAULT 0 COMMENT '创建人' AFTER `spend_time`;
-- 2023-03-09 17:34:42 by anjie
ALTER TABLE `aj_test_job_history` MODIFY COLUMN `job_jenkins_file` varchar(2000) COMMENT '执行脚本' AFTER `jenkins_build_report_url`;
