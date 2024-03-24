package com.example.jibshop.services;

import com.example.jibshop.entitys.User;
import com.example.jibshop.entitys.enums.Role;
import com.example.jibshop.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String userEmail = user.getEmail();
        Optional<User> existingUser = Optional.ofNullable(userRepo.findByEmail(userEmail));
        if (existingUser.isEmpty()) {
            user.setActive(true);
            user.getRoles().add(Role.ROLE_USER);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            log.info("Saving new User with email: {}", userEmail);
            userRepo.save(user);
            return true;
        } else {
            return false; // Пользователь с таким email уже существует
        }
    }


    public List<User> list() {
        return userRepo.findAll();
    }



    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }
}