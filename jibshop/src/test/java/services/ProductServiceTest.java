package services;


import com.example.jibshop.configuration.SecurityConfig;
import com.example.jibshop.entitys.Product;
import com.example.jibshop.entitys.User;
import com.example.jibshop.repositories.ProductRepo;
import com.example.jibshop.repositories.UserRepo;
import com.example.jibshop.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest

class ProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private ProductService productService;

    @Test
    void testListProducts() {
        // Given
        String title = "Test Title";
        List<Product> productList = List.of(new Product(), new Product());
        when(productRepo.findByTitle(title)).thenReturn(productList);

        // When
        List<Product> result = productService.listProducts(title);

        // Then
        assertEquals(productList, result);
    }

    @Test
    void testSaveProduct() throws IOException {
        // Given
        Principal principal = mock(Principal.class);
        Product product = new Product();
        MultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "Hello, World!".getBytes());
        when(userRepo.findByEmail(any())).thenReturn(new User());

        // When
        productService.saveProduct(principal, product, file);

        // Then
        verify(productRepo, times(1)).save(product);
    }

    @Test
    void testDeleteProduct() {
        // Given
        Long id = 1L;

        // When
        productService.deleteProduct(id);

        // Then
        verify(productRepo, times(1)).deleteById(id);
    }

    @Test
    void testGetProductById() {
        // Given
        Long id = 1L;
        Product product = new Product();
        when(productRepo.findById(id)).thenReturn(java.util.Optional.of(product));

        // When
        Product result = productService.getProductById(id);

        // Then
        assertEquals(product, result);
    }
}
