package com.alejandro.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.alejandro.springboot.di.app.springboot_di.models.Product;
import com.alejandro.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private Environment environment;

    // @Autowired
    // @Qualifier("productJson")
    private ProductRepository repository;

    //     public ProductServiceImpl(ProductRepository repository) {
    //     this.repository = repository;
    // }

    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            @SuppressWarnings("null")
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            //Product newProd = new Product(p.getId(),p.getName(), priceTax.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    // @Override
    // public List<Product> findAll() {
    //     return repository.findAll().stream().map(p -> {
    //         Double priceTax = p.getPrice() * 1.25d;
    //         p.setPrice(priceTax.longValue());
    //         return p;
    //     }).collect(Collectors.toList());
    // }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
