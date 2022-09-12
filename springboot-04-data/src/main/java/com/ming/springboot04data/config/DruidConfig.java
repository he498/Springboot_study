package com.ming.springboot04data.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    
    //后台监控功能 :web.xml 记得注册bean
    //springboot 内置servlet容器 ，所以没有Web.xml 需要时，替代方法：
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String,String> iniParameters = new HashMap<>();
        //登录key是固定的！loginUsername和loginPassword
        iniParameters.put("loginUsername","admin");
        iniParameters.put("loginPassword","123456");
        //允许谁可以访问
        iniParameters.put("allow","");
        //禁止谁能访问
//        iniParameters.put("ming","192.168.1.1");

        //密码配置
        bean.setInitParameters(iniParameters);
        return bean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());
        //过滤哪些请求？
        Map<String,String> iniParameters = new HashMap<>();
        //这些东西不进行统计
        iniParameters.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(iniParameters);
        return bean;
    }
}
