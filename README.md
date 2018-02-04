## 平台简介

>Good权限管理系统是作者学习springBoot时基于springBoot开发的一套轻量级的权限系统，其目的是形成一套属于自己的通用的开发框架
>以后来项目的时候就可以直接基于此平台进行开发，减少重复工作量.
>目前还有好多功能未实现，后续会陆续完成并全部开源！

- 访问地址: 
    > 链接: [http://localhost:8081/admin/index](http://localhost:8081/admin/index)
    >
    > 用户名: admin
    >
    > 密码: 123
    
- 演示地址
      - http://139.224.112.51:8082/admin/index
      - 账号:test  密码:test

- 待完成:
    > 1. 加密规则 加盐 (先不解决)
    > 2. 项目启动 初始化admin权限信息 (先不解决)
    > 3. 添加完菜单资源后，超级管理员自动分配权限(先不解决)
    > 4. 添加spring cache使用基于注解方式的缓存管理，同时可以切换任意第三方缓存

## 主要功能介绍

1. 权限: 使用Shiro进行权限控制，灵活的可控制到页面或按钮，满足绝大部分的权限需求.
2. 数据库: 使用Druid数据库连接池，可以监控数据库访问性能，SQL执行效率进行SQL优化，同时使用多环境配置方式可以动态切换到开发环境、测试环境、生产环境. 
3. 日志：使用Logback进行日志输出，使用多环境配置方式可以动态切换到开发环境、测试环境、生产环境,同时基于时间和文件大小分割日志文件并进行归档.
4. 任务调度: 使用Spring+Quartz，基于数据库的分布式定时任务，既可以通过Http的方式调用其它项目的RESTFull接口，也可以执行自己本地的调度任务，支持动态增加、删除、修改任务、暂停|恢复、立即执行一次、查看执行记录，无需重启.
5. 公共异常处理和数据校验

## 内置功能

1. 系统管理
     - 用户管理(已完成)
     - 角色管理(已完成)
     - 权限管理(已完成)
     - 组织机构(未完成)
     - 字典管理(未完成)
     - SQL监控(已完成)
     - 在线用户管理
2. 调度管理(完成)
3. 内容管理(未完成)
4. 日志管理(已完成)
    
## 开发环境

* Intellij IDEA 2016.2
* jdk 1.8
* Maven 3.3.9
* Tomcat 8.5
* Mysql 5.7
* Navicat for Mysql
* Google浏览器

## 技术选型

1、后端

* 核心框架：Spring Boot 1.5.4
* 视图框架：Spring MVC 4.3.9
* 安全框架：Apache Shiro 1.3.2
* 任务调度：Spring+Quartz 2.x 
* 持久层框架：Mybatis 3.4.4 + Mybatis Plus 2.1.9
* 服务端验证：Hibernate validator 5.3.5
* API生成工具: Swagger2
* 单元测试：Junit 4.12
* 网络客户端：Spring RestTemplate(OKGO) + OKHttp
* Email客户端：Spring + JavaMail
* 模板引擎：Thymeleaf 3.0.0
* 数据库连接池：Alibaba Druid 1.1.0
* 缓存框架：Spring Cache + Ehcache 2.5.3
* 日志管理：SLF4J 1.7.22 + Logback 1.1.8
* 分页插件：PageHelper 5.0.3
* 工具类：Apache Commons、Jackson 2.2、Lombok 1.16.14、Hutool 2.16.0、feilong-core 1.10.5

1、前端

* UI框架：H-UI 3.0
* JS框架：jQuery 1.11.0
* 表单验证控件：Jquery-validation 1.14.0
* 树结构控件：zTree v3
* 分页控件：laypage 1.3
* 弹出层组件：layer 2.4
* 富文本编辑器：ueditor 1.4.3
* 上传文件控件：webuploader 0.1.5
* 日期选择控件：My97DatePicker 4.8
* 数据图表：echarts 3.4.0
* 表单美化插件：iCheck 0.7

## 功能展示
![输入图片说明](https://git.oschina.net/uploads/images/2017/0424/112506_6f6953e8_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0424/112608_ad3834e5_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0424/112626_13d68392_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0424/112633_3a416d99_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0424/112642_bf3f3e2a_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0424/112651_b3408011_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0509/092341_07ee27ba_798427.jpeg "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0509/092401_a151ffcf_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0521/210630_7ef7a3a8_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0521/210653_bfbd06e2_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0521/210707_508cad83_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0521/210720_3ac69a9d_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0521/210733_c4f35d0e_798427.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0726/174534_da8e44f7_798427.jpeg "F))1%[4%K)(4AV26JRZ(KQF.jpg")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0801/010933_e3a2c8a1_798427.png "]6A~)`7ZYGFV_ZN4)MOEL1V.png")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0801/011035_7bfa014a_798427.png "9U2H[$G@DHZEG7P}(ZD6PLR.png")

## 特别说明

因为本人能力有限，如果系统中存在任何Bug或者缺陷，欢迎大家及时告知我，希望于大家共同学习！

## QQ交流群[641213116](http://shang.qq.com/wpa/qunwpa?idkey=b047cee4542e383ad5a476bbf021c898fdad18311939d4dc365fa6c8349901ee "Good通用后台交流(不定时发放福利)")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0516/091125_f9478acc_798427.png "在这里输入图片标题")
> **注:不定期发放福利干货!!**

## 特别鸣谢
- [Looly / hutool](http://git.oschina.net/loolly/hutool)   一个Java基础工具类，对文件、流、加密解密、转码、正则、线程、XML等JDK方法进行封装，组成各种Util工具类
- [feilong / feilong-core](https://github.com/venusdrogon/feilong-core)   让Java开发更简便的工具包，让你从大量重复的底层代码中脱身,提高工作效率
- [baomidou / mybatis-plus](https://gitee.com/baomidou/mybatis-plus)   mybatis 增强工具包，简化 CRUD 操作。 文档：http://mp.baomidou.com
- [人人开源 / renren-security](http://git.oschina.net/babaio/renren-security)   renren-security是一个轻量级权限管理系统
- [H-ui / admin](http://store.h-ui.net/H-ui.admin_v3.0/index.html)   H-ui.admin是用H-ui前端框架开发的轻量级网站后台模版
