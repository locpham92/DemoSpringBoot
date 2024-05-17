package com.codegym.demospringboot2.service;

import com.codegym.demospringboot2.model.Product;

import java.util.List;

public interface IProductService extends IGenerateService<Product> {
    List<Product> findAllByPrice(int from, int to);

    List<Product> findByNameContaining(String name);

    Product findByIdCustom(Long id);
}
