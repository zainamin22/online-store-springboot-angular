package com.example.cart.external.service;

import com.example.cart.model.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductService {
    @GetMapping("/products/{id}")
    ProductDTO getProductById (@PathVariable long id);
}
