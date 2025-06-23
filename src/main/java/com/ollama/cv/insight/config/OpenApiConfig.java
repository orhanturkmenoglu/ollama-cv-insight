package com.ollama.cv.insight.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(buildInfo())
                .externalDocs(buildExternalDocs());
    }

    private Info buildInfo() {
        return new Info()
                .title("Ollama CV Insight API")
                .description("AI-powered PDF resume analysis service. This API reads PDF format CVs to identify strengths, weaknesses, and suitable positions.")
                .version("1.0.0")
                .contact(buildContact())
                .license(buildLicense());
    }

    private Contact buildContact() {
        return new Contact()
                .name("Orhan Türkmenoğlu")
                .email("orhantrkmn749@gmail.com")
                .url("https://github.com/orhanturkmenoglu");
    }

    private License buildLicense() {
        return new License()
                .name("Apache 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0");
    }

    private ExternalDocumentation buildExternalDocs() {
        return new ExternalDocumentation()
                .description("GitHub Repository")
                .url("https://github.com/orhanturkmenoglu/ollama-cv-insight");
    }

}
