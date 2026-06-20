SpringBoot 后台权限管理系统

一、项目简介

&#x09;基于 SpringBoot3 + MyBatis-Plus + SpringSecurity + Thymeleaf 实现标准 RBAC 五表权限系统，实现用户 / 角色 / 权限管理、多对多分配、登录认证、分页 CRUD。

1. &#x09;技术栈
SpringBoot3.1.5 | JDK18 | MySQL8 | MyBatis-Plus | SpringSecurity | JWT | Thymeleaf | Lombok
2. &#x09;核心功能
用户管理：增删改查、分页
角色管理：角色 CRUD、分配权限
3. 权限菜单管理
用户分配角色、角色分配权限
Security 登录鉴权、接口权限注解控制
统一返回体、全局异常处理、分页插件

二、数据库（RBAC 五表）
sys\_user 用户 | sys\_role 角色 | sys\_permission 权限
sys\_user\_role 用户角色关联 | sys\_role\_permission 角色权限关联
	初始化 SQL
CREATE DATABASE admin\_demo DEFAULT CHARACTER SET utf8mb4;
USE admin\_demo;

&#x09;复制文档内完整建表语句执行，自带admin管理员账号（密码123456）

三、环境要求

1. IDE：IDEA2024.1.1
2. JDK：18.0.2
3. Maven：3.8+
4. MySQL：8.x

四、项目配置

1. 修改application.yml数据库账号密码
2. MyBatis-Plus 分页插件已配置，直接使用分页查询
3. JWT 密钥可自行修改

五、启动访问

1. 运行启动类AdminDemoApplication
2. 浏览器访问：http://localhost:8080/login
3. 登录账号：admin / 123456

六、项目结构分层

1. entity：数据库实体
2. mapper：MyBatis-Plus 持久层
3. service：业务逻辑层
4. controller：接口控制层
5. config：配置类（安全、分页）
6. common：统一返回、全局异常
7. utils：JWT 工具
8. templates：Thymeleaf 前端页面

