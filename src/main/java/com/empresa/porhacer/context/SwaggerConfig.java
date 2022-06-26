package com.empresa.porhacer.context;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration //La clase notada con esto tiene la capacidad de crear beans
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.empresa.porhacer.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Todo API",
                "La API REST de PorHacer App.",
                "v1",
                "Terms of service",
                new Contact("linkedin - Diego", "https://www.linkedin.com/in/diegoflorezb/", "diegobolivar2368@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
