package com.example.product.service;

import com.example.product.model.ProductDTO;
import com.example.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.product.util.TestUtil.TEST_PRODUCT_ID;
import static com.example.product.util.TestUtil.getTestProduct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = ProductService.class)
public class ProductServiceTest {
    private final ProductService productService;
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    void getAllProductsAndGetProductByIdTest() {
        assertThat(productRepository).isNotNull();
        assertThat(productService).isNotNull();

        when(productRepository.findAll()).thenReturn(Collections.singletonList(getTestProduct()));
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(getTestProduct()));

        List<ProductDTO> allProducts = productService.getAllProducts();

        assertThat(allProducts).isNotNull().isNotEmpty();
        assertThat(allProducts.get(0).getName()).isEqualTo(getTestProduct().getName());

        Optional<ProductDTO> product = productService.getProductById(TEST_PRODUCT_ID);
        assertThat(product).isPresent();
        assertThat(product.get().getName()).isEqualTo(getTestProduct().getName());

    }
}
