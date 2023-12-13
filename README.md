# 饿了么SpringBoot项目
- [项目任务书](./项目任务书.md) [pdf](./饿了么SpringBoot项目任务书.pdf)
- 数据库文件：[elm.sql](./elm.sql) [elmwithfk.sql](./elmwithfk.sql)

## 环境配置（略）
- JDK 17+
- MySQL 8+
- Node.js 18+


## 1. 构建数据库
新建数据库 `elm`，导入 [elmwithfk.sql](./elmwithfk.sql) 或 [elm.sql](./elm.sql) 文件即可。


## 2. 后端配置
修改 `server/src/main/resources/application.yml` 文件中的配置为自己的配置：
- mysql: `spring.datasource.url`、`spring.datasource.username`、`spring.datasource.password`


## 3. 后端打包运行
进入 `rocketblog` 目录，执行 `mvn clean package` 进行打包。

执行 `java -jar target/elm-0.0.1-SNAPSHOT.jar` 运行后端。


## 4. 前端配置
进入 `frontend` 目录，执行 `npm install` 安装依赖。

运行 `npm run dev` 运行前端。


## 参考
- [gitee-东软饿了么项目，tju2022小学期软件工程综合实践](https://gitee.com/d-xr/elm)
- [gitee-饿了么后端servlet项目代码](https://gitee.com/xujiulong/elm-servlet)
