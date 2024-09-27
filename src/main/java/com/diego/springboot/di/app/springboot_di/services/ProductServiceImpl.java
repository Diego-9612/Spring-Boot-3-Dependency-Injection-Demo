package com.diego.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diego.springboot.di.app.springboot_di.models.Product;
import com.diego.springboot.di.app.springboot_di.repositories.ProductRepository;

/**
 * Propósito: ProductService maneja la lógica de negocio. En este caso,
 * se encarga de calcular los precios con impuestos y de encontrar
 * productos mediante el repository.
 * 
 * Problema Actual: Al igual que en SomeController, ProductService crea
 * manualmente
 * una instancia de ProductRepository. Esto debe evitarse usando inyección de
 * dependencias.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Environment environment;

    private ProductRepository repository;

    /**
     * Para este caso la inyeccion de dependencias se hace por medio del constructor
     * No es necesario hacer uso de la anotacion @Autowired.
     */

    /**
     * Hacemos uso de la anotacion @Qualifier para indicar
     * que implementacion de la interfaz vamos a inyectar
     */

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * public ProductServiceImpl(@Qualifier("RepositoryFoo")ProductRepository
     * repository) {
     * this.repository = repository;
     * }
     */

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;

        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
