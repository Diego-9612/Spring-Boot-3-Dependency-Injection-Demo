package com.diego.springboot.di.app.springboot_di.services;

import com.diego.springboot.di.app.springboot_di.models.Product;
import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product findById(Long id);

}
