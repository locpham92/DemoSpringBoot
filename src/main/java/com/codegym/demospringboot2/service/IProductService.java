package com.codegym.demospringboot2.service;

import com.codegym.demospringboot2.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductService extends IGenerateService<Product> {

}
