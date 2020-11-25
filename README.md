![](https://img.shields.io/badge/zszxz-springboot-orange)![](https://img.shields.io/badge/-mybatisPlus-blue)![](https://img.shields.io/badge/-minio-yellowgreen)![](https://img.shields.io/badge/-shiro-lightgrey)![](https://img.shields.io/badge/-vue-green)![](https://img.shields.io/badge/-elementUI-red)![](https://img.shields.io/badge/-echarts-brightgreen)

# zboot项目简介

zboot 是一款基于 springboot2.1.1，shiro+jwt, elementUI,Vue 架构的轻量级权限后台管理系统；

**账号密码**： `admin/123456`

**接口文档，SQL监控默认账号密码**：zboot/zboot

**后端源码地址**：https://github.com/zszxz/zboot

**前端源码地址**：https://github.com/zszxz/zboot_web

# 主要技术栈

## 后端

- springboot 后台框架
- mybaitsPlus 持久层
- shiro 权限框架
- jwt 无状态管理
- swagger 开放接口文档
- hutool  便捷工具
- lombok  简化开发
- fastjson json交互
- druid 数据源连接池
- oshi 系统监控
- minio 文件系统

## 前端

- vue 前端框架
- ElementUI UI框架
- dataView 图层
- echarts 图层
- axios 接口请求
- ES6 语法



# 系统特性

- 后端统一异常处理；
- 前后端模块化开发，代码逻辑简单明了；
- 支持动态路由，模块按需加载；
- 支持权限拦截，按钮权限；
- 支持系统日志监控；
- 支持在线接口文档；
- 前后端json交互，遵循restful风格开发；

# 系统模块功能

- 首页（系统监控预览）
- 部门管理
- 用户管理
- 角色管理
- 菜单管理
- 数据字典
- SQL监控
- 系统日志
- 接口文档

# 项目功能预览

系统模块部分功能预览如下

首页

![](https://gitee.com/lsc180/images/raw/master/img/20201125085900.png)

部门管理

![](https://gitee.com/lsc180/images/raw/master/img/20201125085947.png)

用户管理

![](https://gitee.com/lsc180/images/raw/master/img/20201125091129.png)

角色管理

![](https://gitee.com/lsc180/images/raw/master/img/20201125091158.png)



菜单管理

![](https://gitee.com/lsc180/images/raw/master/img/20201125091307.png)



系统日志

![](https://gitee.com/lsc180/images/raw/master/img/20201125091351.png)

接口文档

![](https://gitee.com/lsc180/images/raw/master/img/20201125091441.png)

# 项目结构

> common
> 	--config 项目配置类
> 	--exception  统一异常
> 	--result  统一返回结果
> 	--utils  工具类
> modules
> 	--config  -- 系统配置类
>
> ​	--develop  -- 开发模块
> ​	--system  --系统模块 
>
> ZBootApplication -- 启动类



# 捐赠

感谢您的支持，如果本项目对您有用，可以请作者喝杯咖啡

微信

![](https://gitee.com/lsc180/images/raw/master/img/wechat_code.jpg)

# 关注

最后如果想一起学习进步，可以关注作者的公众号

![](https://gitee.com/lsc180/images/raw/master/img/zszxz.jpg)