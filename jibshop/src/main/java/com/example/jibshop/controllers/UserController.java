package com.example.jibshop.controllers;

import com.example.jibshop.entitys.User;
import com.example.jibshop.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.jdbc.mutation.spi.BindingGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String createUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }

        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
            return "registration";
        }

        // Если пользователь валиден и email уникален, создаем пользователя
        userService.createUser(user);
        return "redirect:/login";
    }



    //validation

//    @GetMapping("/hello")
//    public String securityUrl() {
//        return "hello";
//    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("products", user.getProducts());
        return "userinfo";
    }

}