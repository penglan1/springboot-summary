# spring boot的静态资源访问
个人总结的访问顺序：
1. 先检查请求的地址是否能够匹配到特定的handler，若不匹配，则往下继续。
2. 检查是否能够匹配到static/目录下的资源，如果不能匹配，则往下继续。
3. 检查是否能够匹配到webapp/下的资源，如果匹配不到，则404报错。

spring boot相比较于spring mvc，其默认的开放了对特定目录下的静态资源的访问，现在我知道的就有：
1. static目录
2. webapp目录（这个目录很可能是交给default-servlet来管理的，其优先级别也是最低的）

# 整合servlet和filter以及listener
## Servlet
**方法一**：
1. 使用@WebServlet来标注servlet
2. 在启动类中使用@ServletComponentScan对servlet进行扫描
**方法二**：
使用bean注册ServletRegistrationBean

## Filter
方法和servlet的类似

## Listener
方法和Servlet以及Filter是类似的

# 注解使用

## 属性配置的变化
### 1. @PropertySource
这个是spring的一个注解，配合@Configuration一起使用，为配置类指定配置属性
```cfml
@Configuration
@PropertySource("classpath:config/jdbc.properties")
public class JDBCProperties {
    @Value("${jdbc.driverClass}")
    private String driverClassName;

    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public ComboPooledDataSource createDataSources() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        return dataSource;
    }
}
```

@Value注解可以被使用在@Controller，@Service，@Repository等注解中，作用于
域，方法的参数等上面，获取上下文配置中的指定的key对应的值

### 2. @ConfigurationProperties
这是spring boot的属性注入方式。使用@ConfigurationProperties注解将application配置文件中的属性注入到对应的实体bean中。
注意，只有在接下来使用了@EnableConfigurationProperties才会去获取标注了@ConfigurationProperties的
注解，将标注的对象进行实例化。
```cfml
@ConfigurationProperties(prefix = "spring.datasource")
public class SBootJDBCProperties {
    private String driverClassName;

    private String jdbcUrl;

    private String user;

    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
```
使用：
```cfml
@Configuration
@EnableConfigurationProperties(SBootJDBCProperties.class)
public class SBootPropertiesConfig {
    @Bean
    public ComboPooledDataSource createDataSources(SBootJDBCProperties sBootJDBCProperties) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(sBootJDBCProperties.getDriverClassName());
        dataSource.setJdbcUrl(sBootJDBCProperties.getJdbcUrl());
        dataSource.setUser(sBootJDBCProperties.getUser());
        dataSource.setPassword(sBootJDBCProperties.getPassword());
        return dataSource;
    }

    /**
     * 更加优雅的方式进行属性配置
     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public ComboPooledDataSource createDataSource() {
//        return new ComboPooledDataSource();
//    }
}
```

### 3. 更加优雅的使用@ConfigurationProperties注解
直接在@Bean的方法上使用，则会对返回的bean进行属性的输入
```cfml
@Configuration
//@EnableConfigurationProperties(SBootJDBCProperties.class)
public class SBootPropertiesConfig {
    /*@Bean
    public ComboPooledDataSource createDataSources(SBootJDBCProperties sBootJDBCProperties) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(sBootJDBCProperties.getDriverClassName());
        dataSource.setJdbcUrl(sBootJDBCProperties.getJdbcUrl());
        dataSource.setUser(sBootJDBCProperties.getUser());
        dataSource.setPassword(sBootJDBCProperties.getPassword());
        return dataSource;
    }*/

    /**
     * 更加优雅的方式进行属性配置
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public ComboPooledDataSource createDataSource() {
        return new ComboPooledDataSource();
    }
}

```

# spring boot的yaml配置文件
和properties配置文件一样，只不过表示的方式采用了树状层次结构。
```cfml
jdbc:
    driverClassName: jdbc....
    url: mysql/...
    ...
    
other:
    abc: hahah
    setjihe:
        - a
        - b
        - c

```


## 1. 多个yml文件配置
可以将多个yml配置文件在application.yml配置文件中激活。

1. 多个yml配置文件在spring boot中是被允许的，但其文件的命名方式必须遵从application-XXX.yml的形式。
如果想要使用这些配置文件，必须要在application.yml配置文件中激活才能被使用。
```cfml
# 激活配置文件时，只需要指定application-XXX.yml中的XXX即可
spring:
    profiles:
        active: abc, def

```

2. properties配置文件和yml配置文件同时存在是允许的。并且如果两个配置文件中存在同名的key，则properties
配置文件中的会覆盖yml中的，即properties配置文件的级别更高。

# <font color='red'>Spring boot的自动配置流程</font>
**这个相当的重要**

1. 在META-INFO/spring.factories文件中有很多的自动配置项
2. 每个自动配置项都有其对应的XXXProperties属性对象类
   如果想要知道一个框架类的具体配置，可以找到对应的XXXProperties配置类，结合@ConfigurationProperties(prefix = "XXX")
   和属性，就可以知道在application.yml配置文件中应该如何配置该框架类了。
3. 自动配置注册是通过XXXAutoConfiguration来完成的，类和方法等都有很多条件注解，只有满足了对应的条件才会去启动该配置类或方法
进行一系列的bean的注册。

**注意：**
> 如果在做配置时，完整的属性配置路径为:
```cfml
@ConfigurationProperties注解中的prefix + 内部类名（如果属性在内部类中的话，需要先new，通常为类名的小写形式）+ 属性名
EG:
server:
    port: 80
    servlet:
        classPath: /sbs
```

# lombok应用
使用lombok插件可以简化POJO，使其POJO看起来更加的简介，便于维护。

## 使用Lombok
1. 为了解决编写源码时的提示没有get和set方法的报错，需要在IDEA中下载插件lombok
2. 在项目的pom.xml添加lombok依赖
3. 改造实体类使用lombok注解

# 静态资源
位于...spring-boot-autoconfigure.jar下面的web下的一个ResourceProperties类，其定义了静态资源的目录、

# 编写spring mvc拦截器
1. 编写拦截器
2. 编写配置类实现WebMvcConfigure接口，在该类中添加各种组件

> only one {@code @Configuration} class may have the {@code @EnableWebMvc} annotation to 
import the Spring Web MVC configuration. There can however be multiple {@code @Configuration} 
classes implementing {@code WebMvcConfigurer} in order to customize the provided configuration.

# Spring boot整合 事务和连接池
1. 添加事务相关的启动器依赖，mysql相关依赖
2. 内置的数据库连接池Hikali配置(有内置的会优先使用内置的，如果不想要使用这个，可以exclusion它)
3. 编写业务类Service使用事务注解@Transactional

**如果不想使用内置的数据源，可以有如下两种方法：**
1. 使用@Configuration来配置自己的数据源
2. 使用type指定数据源的类型，并同时配置与对应类型中所使用的一致的相关属性
```cfml
spring:
  datasource:
    #指定数据源的类型
    type: com.mchange.v2.c3p0.ComboPooledDataSource
    #c3p0中的url属性
    url: jdbc:mysql://localhost:3306/mybatis-summary?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false
    #c3p0中的用户名属性
    username: root
    #c3p0中的密码属性
    password: 4425320
    #c3p0中的驱动名属性属性
    driverClassName: com.mysql.cj.jdbc.Driver
    #c3p0中的...
    initialPoolSize: 3
    #c3p0中的...
    maxPoolSize: 3
    #c3p0中的...
    idleConnectionTestPeriod: 60
    #c3p0中的...
    breakAfterAcquireFailure: false
    #c3p0中的...
    testConnectionOnCheckin: false
```
**配置特定数据源的配置时，和配置内置数据源的类似，只不过是属性名称可能变了，需要和目标数据源的属性名
称保持一致**。

# Spring boot整合通用Mapper
步骤：
1. 添加启动器依赖
2. 让SysUserMapper继承Mapper<SysUser>
3. 修改启动引导类Application中的mybatis的MapperScan扫描注解为tk开头包名的MapperScan注解
4. 修改实体类，添加JPA注解
5. 改造SysUserService业务类

**注意：** 通用Mapper并不等于JPA，只是模仿了JPA的部分功能。

# Spring boot整合Junit
```cfml
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootSummaryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SysUserServiceTest {
    //...
}
```