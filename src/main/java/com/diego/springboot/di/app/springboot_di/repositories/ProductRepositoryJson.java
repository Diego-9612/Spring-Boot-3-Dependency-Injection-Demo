package com.diego.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.*;

import org.springframework.core.io.*;

import com.diego.springboot.di.app.springboot_di.models.Product;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Esta clase se encarga de cargar una lista de productos desde un archivo JSON,
 * almacenarlos en memoria y proveer métodos para acceder a estos productos, ya
 * sea
 * obteniendo todos los productos o buscando uno por su ID.
 */
public class ProductRepositoryJson implements ProductRepository {

    private List<Product> list;

    /**
     * Al instanciarse, este constructor carga los productos desde el archivo
     * "product.json", ubicado en el classpath del proyecto. Utiliza la clase
     * ObjectMapper para deserializar los datos JSON en objetos Java (Product).
     */
    public ProductRepositoryJson() {

        // Carga el archivo "product.json" desde el classpath usando Spring's Resource
        Resource resource = new ClassPathResource("json/product.json");

        // Instancia de ObjectMapper para manejar la deserialización de JSON a objetos
        // Java
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convierte el archivo JSON en un array de Product y luego lo convierte en una
            // lista
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (StreamReadException e) {

            e.printStackTrace();
        } catch (DatabindException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    @Override
    public List<Product> findAll() {
        return list; 
    }

    
    @Override
    public Product findById(Long id) {
        // Busca en la lista el primer producto cuyo ID coincida con el valor
        // proporcionado
        return list.stream()
                .filter(p -> p.getId().equals(id)) // Filtro: encuentra el producto con el ID dado
                .findFirst() // Toma el primer elemento que cumpla con la condición
                .orElseThrow(); 
    }
}
