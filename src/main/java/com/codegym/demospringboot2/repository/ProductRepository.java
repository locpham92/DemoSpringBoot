package com.codegym.demospringboot2.repository;

import com.codegym.demospringboot2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends JpaRepository<Product, Long> {
}
