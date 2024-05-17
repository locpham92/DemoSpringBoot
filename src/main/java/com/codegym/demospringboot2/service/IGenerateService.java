package com.codegym.demospringboot2.service;

import com.codegym.demospringboot2.model.Category;

import java.util.List;
// CRUD: Create Read Update Delete
public interface IGenerateService<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
