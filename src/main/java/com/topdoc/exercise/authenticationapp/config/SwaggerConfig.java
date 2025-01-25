package com.topdoc.exercise.authenticationapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI topdocOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("TopDoc Authentication API")
                .description("Spring Boot REST API for Authentication")
                .version("1.0.0"));
    }
}
