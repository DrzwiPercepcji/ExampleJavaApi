package com.example.recruitment.controller;

import com.example.recruitment.exception.CategoryNotFoundException;
import com.example.recruitment.manager.CategoryManager;
import com.example.recruitment.entity.Category;
import com.example.recruitment.request.category.CreateCategoryRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "Categories")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    protected CategoryManager categoryManager;

    @GetMapping
    @ApiOperation(value = "Get categories", notes = "This method gets a list of categories.")
    public Iterable<Category> get() {
        return categoryManager.findAll();
    }

    @PostMapping
    @ApiOperation(value = "Create category", notes = "This method creates a new category.")
    public void create(@RequestBody @Valid final CreateCategoryRequest request) {
        final Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        categoryManager.save(category);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "Update category", notes = "This method updates a category.")
    public void update(@RequestBody @Valid final CreateCategoryRequest request, @PathVariable Long id) {
        final Category category = categoryManager.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        categoryManager.save(category);
    }
}
