package com.diego.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.springboot.di.app.springboot_di.models.Product;
import com.diego.springboot.di.app.springboot_di.services.ProductService;

/**
 * Propósito: SomeController es un controlador que maneja las solicitudes HTTP.
 * La anotación @RestController indica que esta clase gestionará las solicitudes
 * y devolverá datos directamente (como JSON).
 * 
 * El método list() devuelve una lista de productos.
 * El método show() devuelve un producto específico
 * basado en el id que recibe como parámetro.
 * Problema Actual: Estás creando una instancia
 * de ProductService manualmente dentro del controlador.
 * Esto rompe el principio de Inversión de Dependencias, ya que el controlador
 * es responsable de crear la instancia del servicio. Aquí es donde la inyección
 * de dependencias
 * juega un papel crucial.
 */

@RestController
@RequestMapping("/api")
public class SomeController {

    
    private ProductService service;

    /**Para este caso la inyeccion de dependencias se hace por medio del metodo Set
     * Se hace uso de la anotacion @Autowired.
     */

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }

}
