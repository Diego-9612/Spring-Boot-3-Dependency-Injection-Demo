package com.diego.springboot.di.app.springboot_di.repositories;

import java.util.*;
import com.diego.springboot.di.app.springboot_di.models.Product;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.SessionScope;

/**
 * La clase ProductRepository simula la capa de acceso a los datos.
 * 
 * Esta clase contiene una lista de productos predefinidos y tiene métodos
 * para obtener todos los productos o buscar uno por su id.
 * En un entorno real, esta clase interactuaría con una base de datos.
 */

/**
 * Hacemos uso de la anotacion @Primary para indicar que es la implementacion
 * principal que deseamos inyectar en el service
 */

//@SessionScope
//@Primary
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    // Constructor que inicializa una lista simulada de productos
    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Core i7", 300L),
                new Product(2L, "Core i5", 400L),
                new Product(3L, "Core i3", 100L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream()
                .filter(p -> p.getId().equals(id)) // Filtra productos por id
                .findFirst()
                .orElse(null);
    }
}
