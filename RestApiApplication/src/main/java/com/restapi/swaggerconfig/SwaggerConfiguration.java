package com.restapi.swaggerconfig;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
	}

	private ApiInfo apiInfo() {

		return new ApiInfo("RecentTransaction REST API", "RecentTransaction Using springboot", "1.0", "Term of service",
				new Contact("Vikash Solanki	", "https://www.we3school.com", "vkashsolanki.2015@gmail.com"),
				"License of Api", "API license URL", Collections.emptyList());
	}

}
