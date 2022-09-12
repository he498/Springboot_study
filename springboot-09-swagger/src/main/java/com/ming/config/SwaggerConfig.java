package com.ming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi //开启swagger3  http://localhost:8080/swagger-ui/#/
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.OAS_30).groupName("admin");
    }


    //配置了swagger的bean实例
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("ming")
                //是否开启swagger
//                .enable(flag)
                .select()
                //RequestHandlerSelectors配置要扫描的方式
                .apis(RequestHandlerSelectors.basePackage("com.ming.controller"))
                //过滤什么路径
//                .paths(PathSelectors.ant("/ming/**"))
                .build();   //工厂模式
    }

    //配置Swagger信息=apiInfo
    private ApiInfo apiInfo(){
//      作者信息
        Contact contact = new Contact("ming","localhost:8080/","11111");
        return new ApiInfo(
                "Ming's Swagger3",
                "Api 文档",
                "1.0",
                "urn:tos",
                contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

}
