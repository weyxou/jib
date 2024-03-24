package com.example.jibshop.repositories;

import com.example.jibshop.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}