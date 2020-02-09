package com.rto.configs;

import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	public Docket docket() {
		
		Docket docket= new Docket(DocumentationType.SWAGGER_2).select()
				.apis(basePackage("com.nikhil.resources.rest"))
				.paths(any())
				.build()
				.apiInfo(apiInfo1());
		return docket;
	}

	private ApiInfo apiInfo1() {
		ApiInfo builder=new ApiInfoBuilder()
				.title("LoginSoft Pvt Limited")
				.description("User Application")
				.contact(new Contact("Nikhil Dasari", "9158310997","nikhildasari"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
		return builder;
	}
}
