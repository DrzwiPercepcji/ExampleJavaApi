package com.example.recruitment.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class AbstractManager<T, R extends CrudRepository<T, Long>> {
    @Autowired
    protected R repository;

    public Optional<T> findById(final Long id) {
        return repository.findById(id);
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public void save(final T entity) {
        repository.save(entity);
    }

    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}
