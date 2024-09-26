package com.diego.springboot.di.app.springboot_di.repositories;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.diego.springboot.di.app.springboot_di.models.Product;

/** Podemos asignar un nuevo nombre a la clase para usarlo en algunos casos de inyeccion de dependencias 
 * junto a la anotacion del tipo de controlador que estamos usando 
 * 
 */
@Repository("RepositoryFoo")
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {

        return Collections.singletonList(new Product(1L, "Hp Monitor", 600L));

    }

    @Override
    public Product findById(Long id) {

        return new Product(id, "Hp Monitor", 600L);
    }

}
