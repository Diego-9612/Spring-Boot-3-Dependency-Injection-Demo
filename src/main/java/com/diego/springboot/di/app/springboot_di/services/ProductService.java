package com.diego.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

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

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;

        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

}
