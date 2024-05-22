package com.codegym.demospringboot2.service.impl;

import com.codegym.demospringboot2.model.Category;
import com.codegym.demospringboot2.repository.CategoryRepository;
import com.codegym.demospringboot2.service.ICategoryService;
import com.codegym.demospringboot2.service.IGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }
    public void save(Category category) {
        categoryRepository.save(category);
    }
    public void remove(Long id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.save(category);
    }


}
