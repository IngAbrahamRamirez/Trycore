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

                                .title("Project Management API")

                                .description("""
                                        REST API for managing users, projects,
                                        activities and Earned Value Management (EVM)
                                        metrics.
                                        """)

                                .version("1.0.0")

                                .contact(

                                        new Contact()

                                                .name("Abraham Ramirez")
                                                .email("abraham@example.com"))

                                .license(

                                        new License()

                                                .name("MIT"))

                );

    }

}