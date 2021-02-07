package com.example.recruitment.controller;

import com.example.recruitment.entity.Category;
import com.example.recruitment.exception.CategoryNotFoundException;
import com.example.recruitment.exception.ProductNotFoundException;
import com.example.recruitment.manager.CategoryManager;
import com.example.recruitment.manager.ProductManager;
import com.example.recruitment.request.product.CreateProductRequest;
import com.example.recruitment.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "Products")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    protected ProductManager productManager;

    @Autowired
    protected CategoryManager categoryManager;

    @GetMapping
    @ApiOperation(value = "Get products", notes = "This method gets a list of products.")
    public Iterable<Product> get() {
        return productManager.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get product", notes = "This method gets a single product.")
    public Product get(@PathVariable Long id) {
        return productManager.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    @PostMapping
    @ApiOperation(value = "Create product", notes = "This method creates a new product.")
    public void create(@RequestBody @Valid final CreateProductRequest request) {
        final Product product = new Product();
        final Category category = categoryManager.findById(request.getCategory())
                .orElseThrow(CategoryNotFoundException::new);

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(category);

        productManager.save(product);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "Update product", notes = "This method updates a product.")
    public void update(@RequestBody @Valid final CreateProductRequest request, @PathVariable Long id) {
        final Product product = productManager.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        final Category category = categoryManager.findById(request.getCategory())
                .orElseThrow(CategoryNotFoundException::new);

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(category);

        productManager.save(product);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete product", notes = "This method deletes a product.")
    public void delete(@PathVariable Long id) {
        try {
            productManager.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new ProductNotFoundException();
        }
    }
}
