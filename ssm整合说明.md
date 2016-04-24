# ssm整合说明
## spring+spring mvc+mybatis
## 说明
由于之前存在ssh框架，spring+struts+hibernate,其中spring负责aop与ioc，所以一般认为spring是ioc与aop容器。

后来spring mvc发展迅速，干掉了struts，所以实现mvc这一模块spring mvc被单独拿出来使用，与spring属于同一个开源项目，

但是不同的子项目，即spring mvc 可以脱离spring使用。



## 整合步骤
### 我们一步一步来，条理清晰一些
1. MAVEN引入jar包
2. 写配置文件log4j.properties(建议将jdbc的sql语句打印出来，方便排查错误)、spring-mybatis.xml、jdbc.properties，这里我们只使用了mybatis和spring,并没有使用spring mvc
3. 设计数据库，因为数据库是项目基础，项目从数据库->dao->service->controller->web browser
4. 根据数据库表写entity，必须一一对应，包括不涉及业务逻辑的id自增主键，这里注意要在pom中配置resource标签，### 否则我们的mapper.xml无法被编译，就会导致找不到dao层的实现方法。
5. 写dao层(全套的就是crud，但是业务线中一般是不允许删除操作、很少有更新操作),因为使用了mybatis所以我们的dao是*mapper.java和*mapper.xml（其实名字无所谓，只要在xml中配置好了就行）
6. 根据业务逻辑写service层，以及他的实现层,也就是面向接口编程
7. 写一个测试类，测试spring与mybatis是否整合成功
8. 测试成功以后，我们开始配置spring mvc，这时候大家会发现spring+mybatis并不是一个web工程，因为和web没有任何关系。spring是ioc+aop容器，而mybatis知识O/R Mapping工具
9. 配置spring-mvc.xml,主要是值controller扫描、视图分发、以及注解支持功能
10. 配置web.xml文件
11. 至此，ssm整合完成，可以测试一下了

