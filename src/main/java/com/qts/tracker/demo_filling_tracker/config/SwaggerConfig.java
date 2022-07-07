package com.qts.tracker.demo_filling_tracker.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
	  @Bean
	    public Docket userApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.qts.tracker.demo_filling_tracker.controller"))
	                .build()
	                .apiInfo(metaInfo());
	    }

	    private ApiInfo metaInfo() {
			 ApiInfo apiInfo = new ApiInfo(
		                "SRFT  Spring Boot API",
		                "SRFT  Spring Boot Swagger API Document",
		                "1.0",
		                "Terms of Service",
		                new Contact("Quantumware Technical Services Private Limited", "https://www.quantumware.in/",
		                        "info@quantumware.co.in"),
		                "Apache License Version 2.0",
		                "https://www.apache.org/licesen.html"
		        );
			 return apiInfo;
		 }
}
