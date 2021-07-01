package com.upc.incident;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
@Import(SwaggerConfiguration.class)
public class SpringfieldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringfieldApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

	}

}

@Configuration
class RestTemplateConfig {
	// Crea un bean para que restTemplate pueda llamar a los servicios REST
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.burritogoupc.pe"))
				.paths(regex("/.*"))
				.build();
	}
}
