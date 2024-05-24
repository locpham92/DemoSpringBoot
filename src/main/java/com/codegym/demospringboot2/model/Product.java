package com.codegym.demospringboot2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private String image;

    @ManyToOne
    public Category category;

    // fetch LAZY: tăng hiệu suất truy vấn, cascade: ALL khi thêm ở bảng này sẽ đồng bộ toàn bộ ở bảng kia, với các tác vụ thêm, sửa, xóa
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_brand",
            joinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "brand_id", referencedColumnName = "id")
            })
    // Set là 1 dạng List mà các phần tử bắt buộc phải khác nhau
    private Set<Brand> brand;



}
