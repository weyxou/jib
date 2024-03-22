package com.example.jibshop.services;

import com.example.jibshop.models.Image;
import com.example.jibshop.models.Product;
import com.example.jibshop.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public void saveProduct(Product product, MultipartFile file1) throws IOException {
        Image image1;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }

        log.info("new Product. Title: {};", product.getTitle());
        Product productFromDb = productRepo.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepo.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }


    public void deleteProduct(Long id) {
productRepo.deleteById(id);
    }
    public Product getProductById(Long id) {
    return productRepo.findById(id).orElse(null);
    }
}
