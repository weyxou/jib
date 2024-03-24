package controllers;


import com.example.jibshop.controllers.UserController;
import com.example.jibshop.entitys.User;
import com.example.jibshop.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void login() {
        Model model = mock(Model.class);
        Principal principal = mock(Principal.class);
        User user = new User();

        when(userService.getUserByPrincipal(principal)).thenReturn(user);

        String viewName = userController.login(principal, model);

        assertEquals("login", viewName);
        verify(model).addAttribute("user", user);
    }

    @Test
    void profile() {
        Model model = mock(Model.class);
        Principal principal = mock(Principal.class);
        User user = new User();

        when(userService.getUserByPrincipal(principal)).thenReturn(user);

        String viewName = userController.profile(principal, model);

        assertEquals("profile", viewName);
        verify(model).addAttribute("user", user);
    }



    @Test
    void createUser() {
        Model model = mock(Model.class);
        User user = new User();

        when(userService.createUser(user)).thenReturn(true);

        String viewName = userController.createUser(user, model);

        assertEquals("redirect:/login", viewName);
    }


}