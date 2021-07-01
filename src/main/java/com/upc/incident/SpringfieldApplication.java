package com.upc.incident;

import com.upc.incident.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaAuditing
@Import(SwaggerConfiguration.class)
public class SpringfieldApplication implements WebMvcConfigurer {

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
