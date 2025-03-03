# 项目开发手册
## 1. 环境安装
### 安装相关软件

安装MySQL

安装Redis

安装java

安装NodeJS

安装IDEA

安装GIT/TORTOISEGIT

**相关软件可以从ftp://10.6.19.251上下载安装**

se20/20se

### 获取代码

使用Tortoise Git拉取项目代码，并切换到asset分支



## 2. 初始化配置

### 修改Redis登录密码

为保证系统安全，Redis请设置密码。修改redis.windows-service.conf文件中的requirepass为相应密码，并重启Redis。

### 数据库初始化

运行如下脚本，创建相应的数据库用户及数据库，为保证安全不建议使用数据库的root账号

```sql
CREATE USER ruoyi_asset IDENTIFIED BY '123.asset';
CREATE DATABASE ruoyi_asset ;
GRANT SELECT ON mysql.user TO ruoyi_asset;
GRANT ALL PRIVILEGES ON  ruoyi_asset.* TO  ruoyi_asset@`%`  WITH GRANT OPTION; 
FLUSH PRIVILEGES;
```

运行项目sql文件夹下的ry.sql, quartz.sql, asset.sql 三个脚本文件，创建初始表格。



### 项目配置初始化

修改项目中的application.yml中 redis.password为redis.conf中的相应值，密码建议用双引号包裹

修改项目中的application-druid.yml中spring.datasource.durid.master 中url, username, password为数据库初始化中设置的相应内容

使用maven导入相应后端依赖

 进入ruoyi-ui文件夹，运行```npm install -save```安装前端依赖



## 项目运行

配置IDEA ,添加SpringBoot类型的configuration，运行后端

配置IDEA, 添加npm类型的configuration, 运行前端

