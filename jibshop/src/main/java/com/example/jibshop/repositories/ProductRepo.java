package com.example.jibshop.repositories;

import com.example.jibshop.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
