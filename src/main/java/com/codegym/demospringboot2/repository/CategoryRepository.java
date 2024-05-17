package com.codegym.demospringboot2.repository;

import com.codegym.demospringboot2.model.Category;
import com.codegym.demospringboot2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class CategoryRepository extends JpaRepository<Category, Long> {
}
