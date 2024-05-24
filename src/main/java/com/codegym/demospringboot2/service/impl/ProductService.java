package com.codegym.demospringboot2.service.impl;

import com.codegym.demospringboot2.model.Product;
import com.codegym.demospringboot2.model.Brand;
import com.codegym.demospringboot2.repository.BrandRepository;
import com.codegym.demospringboot2.repository.ProductRepository;
import com.codegym.demospringboot2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
    public void save(Product product) {
        // Lấy ra danh sách các brand có trong database
        Set<Brand> brands = product.getBrand();
        if (!brands.isEmpty()) {
            Set<Brand> managedBrand = new HashSet<>();
            for (Brand brand : brands) {
                if (brand.getId() != null) {
                    Optional<Brand> optionalBrand = brandRepository.findById(brand.getId());
                    managedBrand.add(optionalBrand.get());
                }
            }
            product.setBrand(managedBrand);
        }
        productRepository.save(product);
    }
    public void remove(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.save(product);
    }
    public List<Product> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }
    public List<Product> findByCategory_Id(Long id) {
        return productRepository.findByCategory_Id(id);
    }


}
