package com.example.product.model;

import com.example.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;

    public ProductDTO (Product product){
        setId(product.getId());
        setName(product.getName());
        setPrice(product.getPrice());
    }

}