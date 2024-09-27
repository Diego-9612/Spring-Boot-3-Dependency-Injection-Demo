package com.diego.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.diego.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.diego.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    @Primary
    ProductRepository productRepository(){
        return new ProductRepositoryJson();
    }
    
}
