package com.codegym.demospringboot2.controller;

import com.codegym.demospringboot2.model.Product;
import com.codegym.demospringboot2.service.ICategoryService;
import com.codegym.demospringboot2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.SSLEngineResult;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    public IProductService productService;

    @Autowired
    public ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> list = productService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
