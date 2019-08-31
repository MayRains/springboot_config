package com.atguigu.springboot_config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerBeanMapper {

    @Bean
    public DozerBeanMapper mapper(){
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper;
    }
}
