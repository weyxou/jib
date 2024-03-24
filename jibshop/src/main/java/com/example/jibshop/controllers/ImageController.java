package com.example.jibshop.controllers;

import com.example.jibshop.entitys.Image;
import com.example.jibshop.repositories.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayInputStream;

@RequiredArgsConstructor
public class ImageController {
    private final ImageRepo imageRepo;

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        Image image = imageRepo.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
