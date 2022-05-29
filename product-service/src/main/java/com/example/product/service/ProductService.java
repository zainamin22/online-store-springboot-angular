package com.example.product.service;

import com.example.product.model.ProductDTO;
import com.example.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().
                map(ProductDTO::new).collect(Collectors.toList());
    }
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(ProductDTO::new);
    }
}
