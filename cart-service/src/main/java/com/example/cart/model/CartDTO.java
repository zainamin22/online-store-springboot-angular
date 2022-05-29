package com.example.cart.model;

import com.example.cart.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long productId;

    public CartDTO (Cart cart){
        setProductId(cart.getProductId());
    }
}
