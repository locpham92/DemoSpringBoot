package com.codegym.demospringboot2.controller;

import com.codegym.demospringboot2.model.Category;
import com.codegym.demospringboot2.model.Product;
import com.codegym.demospringboot2.service.ICategoryService;
import com.codegym.demospringboot2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
        public ICategoryService categoryService;

        @GetMapping("")
        public ResponseEntity<List<Category>> getAll() {
            List<Category> list = categoryService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
}
