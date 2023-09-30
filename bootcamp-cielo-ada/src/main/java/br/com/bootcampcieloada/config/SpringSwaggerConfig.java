package br.com.bootcampcieloada.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringSwaggerConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()//
				.info(new Info() //
						.title("Bootcamp Cielo ADA") //
						.description("Api cadastro cliente") //
						.version("versao 1.0")); //
	}
}