package com.unifacisa.banco.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl("https://bezkoder-api.com");
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("matheus.maia.pereira@maisunifacisa.com");
        contact.setName("Matheus");
        contact.setUrl("https://www.google.com");

        License mitLicense = new License().name("MIT License")
                .url("https://www.google.com");

        Info info = new Info()
                .title("API Banco")
                .version("2.1")
                .contact(contact)
                .description("Api de conta bancaria.")
                .termsOfService("https://www.google.com")
                .license(mitLicense);
        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));

    }
}