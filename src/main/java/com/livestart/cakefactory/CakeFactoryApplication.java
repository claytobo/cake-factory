package com.livestart.cakefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
@ComponentScan(basePackages={"com.livestart"})
public class CakeFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeFactoryApplication.class, args);
	}

}
