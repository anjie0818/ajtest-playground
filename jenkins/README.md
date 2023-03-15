* 下载地址
* https://mirrors.jenkins-ci.org/war/latest/
```sh
java -jar jenkins.war --httpPort=9090 --enable-future-java & 
```
* jenkins安全策略
* /script
* System.setProperty("hudson.model.DirectoryBrowserSupport.CSP","script-src 'self' 'unsafe-inline'")