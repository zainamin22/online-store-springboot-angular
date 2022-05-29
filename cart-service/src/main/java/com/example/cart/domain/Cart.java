package com.example.cart.domain;

import com.example.cart.model.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {
    @Id
    private Long productId;

    public Cart (CartDTO cartDTO){
        setProductId(cartDTO.getProductId());
    }
}
