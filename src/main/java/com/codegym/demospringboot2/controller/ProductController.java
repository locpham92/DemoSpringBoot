package com.codegym.demospringboot2.controller;

import com.codegym.demospringboot2.service.ICategoryService;
import com.codegym.demospringboot2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    public IProductService productService;

    @Autowired
    public ICategoryService categoryService;
}
