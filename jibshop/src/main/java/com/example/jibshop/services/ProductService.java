package com.example.jibshop.services;

import com.example.jibshop.models.Product;
import com.example.jibshop.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;
    public List<Product> listProducts(String title) {
        if (title != null) return productRepo.findByTitle(title);
        return productRepo.findAll();
    }
    public void saveProduct(Product product){
        log.info("saving new {}", product);
        productRepo.save(product);
    }
    public void deleteProduct(Long id) {
productRepo.deleteById(id);
    }
    public Product getProductById(Long id) {
    return productRepo.findById(id).orElse(null);
    }
}
