package com.diego.springboot.di.app.springboot_di.repositories;

import java.util.*;
import com.diego.springboot.di.app.springboot_di.models.Product;
import org.springframework.stereotype.Repository;

/**
 * La clase ProductRepository simula la capa de acceso a los datos.
 * 
 * Esta clase contiene una lista de productos predefinidos y tiene métodos
 * para obtener todos los productos o buscar uno por su id.
 * En un entorno real, esta clase interactuaría con una base de datos.
 */

@Repository
public class ProductRepository {

    private List<Product> data;

    // Constructor que inicializa una lista simulada de productos
    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "Core i7", 300L),
                new Product(2L, "Core i5", 400L),
                new Product(3L, "Core i3", 100L));
    }

    public List<Product> findAll() {
        return data;
    }

    
    public Product findById(Long id) {
        return data.stream()
                .filter(p -> p.getId().equals(id)) // Filtra productos por id
                .findFirst()
                .orElse(null);
    }
}
