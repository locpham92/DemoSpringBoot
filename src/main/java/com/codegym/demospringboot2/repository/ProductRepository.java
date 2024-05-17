package com.codegym.demospringboot2.repository;

import com.codegym.demospringboot2.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPrice(int from, int to);

    List<Product> findByNameContaining(String name);

    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Optional<Product> findByIdCustom(@Param("id") Long id);
}
