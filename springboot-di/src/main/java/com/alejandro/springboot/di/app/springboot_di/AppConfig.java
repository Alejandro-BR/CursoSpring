package com.alejandro.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.alejandro.springboot.di.app.springboot_di.repositories.ProdcutRepositoryJson;
import com.alejandro.springboot.di.app.springboot_di.repositories.ProductRepository;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("classpath:json/product.json")
    private Resource resource;

    @Bean("productJson")
    ProductRepository productRepositoryJson() {
        return new ProdcutRepositoryJson(resource);
    }
}
