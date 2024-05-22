package com.codegym.demospringboot2.controller;

import com.codegym.demospringboot2.model.Product;
import com.codegym.demospringboot2.service.ICategoryService;
import com.codegym.demospringboot2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.util.List;

@Controller
@CrossOrigin("*")
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

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Product product) {
       productService.save(product);
       String message = "Added successfully";
       return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        String message = "Edited successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productService.remove(id);
        String message = "Deleted successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@Param("name") String name) {
    List<Product> list = productService.findByNameContaining(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<List<Product>> search(@PathVariable Long id) {
        List<Product> list = productService.findByCategory_Id(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
