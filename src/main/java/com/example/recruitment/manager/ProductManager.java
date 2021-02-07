package com.example.recruitment.manager;

import com.example.recruitment.repository.ProductRepository;
import com.example.recruitment.entity.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ProductManager extends AbstractManager<Product, ProductRepository> {

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        Product test1 = new Product();
        Product test2 = new Product();

        test1.setName("Test product 1");
        test2.setName("Test product 2");

        save(test1);
        save(test2);
    }
}
