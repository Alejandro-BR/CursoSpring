package com.alejandro.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alejandro.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.alejandro.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara soni", 800);
        Product p2 = new Product("Bicicleta", 1200);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }

    @Bean("default")
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Monitor Lenovo", 700);
        Product p2 = new Product("ThinkPad", 2000);
        Product p3 = new Product("Raton", 30);
        Product p4 = new Product("Teclado", 120);
        return Arrays.asList(new Item(p1, 4), new Item(p2, 6), new Item(p3, 4), new Item(p4, 3));
    }
}
