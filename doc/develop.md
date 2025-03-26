# 项目开发快速入门手册
## 1. 环境安装
### 安装相关软件

安装MySQL

[mysql installer community 8.0.16.0安装配置图文教程_mysql-installer-community-8.0.16.0-CSDN博客](https://blog.csdn.net/weixin_43398418/article/details/118649843?ops_request_misc=%7B%22request%5Fid%22%3A%2282b7e5a8cb594f46541e2ba5247fae33%22%2C%22scm%22%3A%2220140713.130102334..%22%7D&request_id=82b7e5a8cb594f46541e2ba5247fae33&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~baidu_landing_v2~default-3-118649843-null-null.142^v102^pc_search_result_base6&utm_term=mysql-installer-community-8.0.16.0&spm=1018.2226.3001.4187)

安装Redis

[Redis 安装及配置教程（Windows）【安装】_redis下载安装配置windows-CSDN博客](https://blog.csdn.net/qq_41918107/article/details/138145358?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_utm_term~default-0-138145358-blog-119334531.235^v43^control&spm=1001.2101.3001.4242.1&utm_relevant_index=3)

安装java

示例版本：jdk-23

[JAVA最新版本详细安装教程（附安装包）_java安装-CSDN博客](https://blog.csdn.net/ZHOUPUYU/article/details/144073781?ops_request_misc=%7B%22request%5Fid%22%3A%22fd4d2e20da60f798d28a08e55e24c7e7%22%2C%22scm%22%3A%2220140713.130102334..%22%7D&request_id=fd4d2e20da60f798d28a08e55e24c7e7&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-144073781-null-null.142^v102^pc_search_result_base6&utm_term=java下载安装教程详细&spm=1018.2226.3001.4187)

安装NodeJS

[2024最新版Node.js下载安装及环境配置教程【保姆级】_nodejs下载-CSDN博客](https://blog.csdn.net/WHF__/article/details/129362462?ops_request_misc=%7B%22request%5Fid%22%3A%227412fd7cd0536fcb34090bf23536cd66%22%2C%22scm%22%3A%2220140713.130102334..%22%7D&request_id=7412fd7cd0536fcb34090bf23536cd66&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-129362462-null-null.142^v102^pc_search_result_base6&utm_term=nodejs安装及环境配置&spm=1018.2226.3001.4187)

安装IDEA

[2022最新最全IntelliJ IDEA 的安装与配置_idea2022安装教程及环境配置-CSDN博客](https://blog.csdn.net/qq_46038405/article/details/120922368?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_utm_term~default-0-120922368-blog-140468133.235^v43^control&spm=1001.2101.3001.4242.1&utm_relevant_index=3)

安装GIT/TORTOISEGIT

[Git & TortoiseGit 详细安装使用教程_tortoisegit安装-CSDN博客](https://blog.csdn.net/m0_37383484/article/details/137973086?ops_request_misc=%7B%22request%5Fid%22%3A%2290fea2a8b37872963a91730d6e07421a%22%2C%22scm%22%3A%2220140713.130102334..%22%7D&request_id=90fea2a8b37872963a91730d6e07421a&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-137973086-null-null.142^v102^pc_search_result_base6&utm_term=git和tortoisegit安装配置&spm=1018.2226.3001.4187)

**相关软件可以从ftp://10.6.19.251上下载安装**

se20/20se

### 获取代码

使用 Tortoise Git 拉取项目代码，并切换到 asset 分支



## 2. 初始化配置

### 修改Redis登录密码

为保证系统安全，Redis 请设置密码。修改 redis.windows-service.conf 文件中的 requirepass 为相应密码，并重启 Redis 。

### 数据库初始化

运行如下脚本，创建相应的数据库用户及数据库，为保证安全不建议使用数据库的root账号

```sql
CREATE USER ruoyi_asset IDENTIFIED BY '123.Asset';
CREATE DATABASE ruoyi_asset ;
GRANT SELECT ON mysql.user TO ruoyi_asset@`%`;
GRANT PROCESS ON *.* TO ruoyi_asset@`%` ;
GRANT ALL PRIVILEGES ON  ruoyi_asset.* TO  ruoyi_asset@`%`  WITH GRANT OPTION; 
FLUSH PRIVILEGES;
```

可利用 navicat 或 IDEA 中配置 DataSource 连接上数据库, 运行项目 sql 文件夹下的 ry.sql,  quartz.sql,  asset.sql  三个脚本文件，创建初始表格并添加相关菜单。

详细步骤如下：

###### 一、创建数据库用户及数据库

1. ###### 登录数据库

   - 打开数据库管理工具（如 MySQL Workbench、Navicat 等），使用数据库的管理员账号（如 `root` ）登录到数据库服务器。

   - 如果你使用的是命令行工具，可以通过以下命令登录：

     ```bash
   mysql -u root -p
     ```
     
     然后输入`root`用户的密码。

2. **运行创建用户和数据库的脚本**

   - 在数据库管理工具的 SQL 编辑器中，或者在命令行中，运行以下SQL脚本：

     ```sql
   CREATE USER ruoyi_asset IDENTIFIED BY '123.Asset';
     CREATE DATABASE ruoyi_asset;
     GRANT SELECT ON mysql.user TO ruoyi_asset@`%`;
     GRANT PROCESS ON *.* TO ruoyi_asset@`%`;
     GRANT ALL PRIVILEGES ON ruoyi_asset.* TO ruoyi_asset@`%` WITH GRANT OPTION;
     FLUSH PRIVILEGES;
     ```
     
   - 这些语句的作用如下：

     - `CREATE USER ruoyi_asset IDENTIFIED BY '123.Asset';` 创建了一个名为`ruoyi_asset` 的用户，密码为`123.Asset`。
     - `CREATE DATABASE ruoyi_asset;` 创建了一个名为`ruoyi_asset`的数据库。
     - `GRANT SELECT ON mysql.user TO ruoyi_asset@`%`;` 允许`ruoyi_asset`用户从`mysql.user`表中查询数据。
     - `GRANT PROCESS ON *.* TO ruoyi_asset@`%`;` 允许`ruoyi_asset`用户查看当前数据库的进程信息。
     - `GRANT ALL PRIVILEGES ON ruoyi_asset.* TO ruoyi_asset@`%` WITH GRANT OPTION;` 授予`ruoyi_asset`用户对`ruoyi_asset`数据库的所有权限，并允许其授予权限给其他用户。
     - `FLUSH PRIVILEGES;` 刷新权限，使上述授权生效。

3. **验证用户和数据库创建成功**

   - 在数据库管理工具中，检查是否创建了`ruoyi_asset`用户和`ruoyi_asset`数据库。例如，在 MySQL Workbench 中，可以在左侧的“导航器”中查看用户和数据库列表。

##### 二、配置 Navicat 连接数据库

1. **打开 Navicat**
   - 启动 Navicat 软件。
2. **创建新的连接**
   - 点击“新建连接”按钮。
   - 在“新建连接”对话框中，选择“ MySQL ”作为数据库类型。
   - 填写以下信息：
     - **连接名**：可以自定义，例如`ruoyi_asset_connection`。
     - **主机名/IP地址**：填写数据库服务器的IP地址或主机名。如果是本地数据库，可以填写`localhost`或`127.0.0.1`。
     - **端口**：默认为`3306`，如果你的数据库使用了其他端口，请填写相应的端口号。
     - **用户名**：填写`ruoyi_asset`。
     - **密码**：填写`123.Asset`。
   - 点击“测试连接”按钮，确保连接成功。如果连接失败，检查用户名、密码、主机名和端口是否正确。
   - 点击“确定”保存连接。

##### 三、运行SQL脚本文件

1. **找到SQL脚本文件**
   - 找到项目中的`sql`文件夹，里面应该包含`ry.sql`、`quartz.sql`和`asset.sql`三个文件。
2. **运行SQL脚本**
   - 在Navicat中，连接到刚才创建的`ruoyi_asset`数据库。
   - 在Navicat的“查询编辑器”中，依次运行`ry.sql`、`quartz.sql`和`asset.sql`文件中的SQL语句。
     - 右键单击`ry.sql`文件，选择“打开”，将文件内容复制到Navicat的“查询编辑器”中，然后点击“运行”按钮。
     - 重复上述步骤，依次运行`quartz.sql`和`asset.sql`文件中的SQL语句。
   - 这些SQL脚本的作用是创建初始表格并添加相关菜单。
3. **验证表格和菜单创建成功**
   - 在 Navicat 中，检查`ruoyi_asset`数据库中的表格是否已经创建成功。例如，`ry.sql`文件可能会创建用户表、角色表等，`quartz.sql`文件可能会创建与定时任务相关的表格，`asset.sql`文件可能会创建资产相关的表格。
   - 如果表格和菜单创建成功，说明数据库初始化完成。

通过以上步骤，你可以成功完成数据库的初始化，包括创建用户、数据库以及运行SQL脚本文件。



### 项目配置初始化

修改项目中的 application.yml 中  redis.password 为 redis.conf 中的相应值，密码建议用双引号包裹

修改项目中的 application-druid.yml 中 spring.datasource.durid.master 中 url, username, password 为数据库初始化中设置的相应内容

使用 maven 导入相应后端依赖（ IDEA中 maven 管理可以自动下载依赖）

先利用 ```npm config set registry https://mirrors.huaweicloud.com/repository/npm/``` 配置npm华为镜像源，再进入 ruoyi-ui 文件夹，运行 ```npm install -save```  安装前端依赖。 



## 项目运行

配置 IDEA ,添加 SpringBoot 类型的 configuration ，运行后端

![运行后端1](C:\Users\李欣桐\OneDrive\桌面\GitHubProject\ruoyi-asset\doc\req\images\运行后端1.jpg)

![运行后端2](C:\Users\李欣桐\OneDrive\桌面\GitHubProject\ruoyi-asset\doc\req\images\运行后端2.jpg)

配置 IDEA, 添加 npm 类型的 configuration , 运行前端

![image-20250326152706024](C:\Users\李欣桐\OneDrive\桌面\GitHubProject\ruoyi-asset\doc\req\images\运行前端.jpg)

