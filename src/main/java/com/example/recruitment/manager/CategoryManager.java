package com.example.recruitment.manager;

import com.example.recruitment.repository.CategoryRepository;
import com.example.recruitment.entity.Category;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager extends AbstractManager<Category, CategoryRepository> {

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Category("Category 1", "Desc 1"));
        save(new Category("Category 2", "Desc 2"));
    }
}
