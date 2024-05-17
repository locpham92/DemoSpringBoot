package com.codegym.demospringboot2.service.impl;

import com.codegym.demospringboot2.model.Product;
import com.codegym.demospringboot2.repository.ProductRepository;
import com.codegym.demospringboot2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
    public void save(Product product) {
        productRepository.save(product);
    }
    public void remove(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.save(product);
    }
    public List<Product> findAllByPrice(int from, int to) {
        return null;
    }
    public List<Product> findByNameContaining(String name) {
        return null;
    }

    public Product findByIdCustom(Long id) {
        return null;
    }

}
