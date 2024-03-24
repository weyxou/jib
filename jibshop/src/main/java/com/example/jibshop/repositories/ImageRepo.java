package com.example.jibshop.repositories;

import com.example.jibshop.entitys.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, Long> {
}
