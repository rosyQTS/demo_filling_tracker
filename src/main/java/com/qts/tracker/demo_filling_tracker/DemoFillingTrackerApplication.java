package com.qts.tracker.demo_filling_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@SpringBootApplication
public class DemoFillingTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFillingTrackerApplication.class, args);
	}
	@Configuration
	public class AppConfig {
		@Bean(name = "mvcHandlerMappingIntrospector")
		public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
			return new HandlerMappingIntrospector();
		}
	}


}
