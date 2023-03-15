**目录（Table of Contents）**
## Jmeter接口自动化测试方案
jmeter+maven+extentreport
## 教学视频链接  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
[Jmeter接口自动化脚本结构进阶](https://imooc.com/learn/1227)
## 如何运行Jmx文件,查看执行结果？
* step1:将jmeter的脚本文件jmx放到指导目录下：auto-api-jmeter/src/test/jmeter/testscript
* step2:window/mac/os打开命令行，执行
  ```bash
  cd auto-api-jmeter
  mvnw clean verify
  ```
* step3:查看执行结果
  ```bash
  cd auto-api-jmeter/target/jmeter
  # html报告
  cd extentReport
  # jmeter结果文件
  cd results
  # jmeter运行日志
  cd logs
  ```
