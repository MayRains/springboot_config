package com.atguigu.springboot_config.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class swagger2 {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                        .apiInfo(apiInfo())
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("com.atguigu.springboot_config"))
                        .paths(PathSelectors.regex("/rest/.*"))
                        .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                    .title("Use Swagger Building Api_Doc")
                    .description("simple & elegant Restful style")
                    .termsOfServiceUrl("http://www.zimug.com")
                    .version("1.0")
                    .build();
    }
}
