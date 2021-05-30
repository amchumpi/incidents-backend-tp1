package com.upc.springfield;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringfieldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringfieldApplication.class, args);
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
