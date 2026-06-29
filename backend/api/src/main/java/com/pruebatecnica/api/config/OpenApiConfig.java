package com.pruebatecnica.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI openAPI() {

        return new OpenAPI()

                .info(

                        new Info()

                                .title("Project Management REST API")

                                .description("""

                                        Project Management API

                                        Version 1.0

                                        Spring Boot 3

                                        Java 21

                                        PostgreSQL

                                        JWT Authentication

                                        Earned Value Management (EVM)

                                                                                """)

                                .version("1.0.0")

                                .contact(

                                        new Contact()

                                                .name("Abraham Ramirez")

                                                .email("abraham@email.com"))

                                .license(

                                        new License()

                                                .name("MIT"))

                );

    }

}