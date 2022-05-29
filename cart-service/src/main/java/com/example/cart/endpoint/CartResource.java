package com.example.cart.endpoint;

import com.example.cart.domain.Cart;
import com.example.cart.model.CartDTO;
import com.example.cart.model.ProductDTO;
import com.example.cart.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cart/products")
public class CartResource {
    private final CartService cartService;

    public CartResource(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cart addProductInCart (@RequestBody CartDTO cart) {
        return cartService.addProductInCart(cart);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProductFromCart (@PathVariable Long productId) {
      cartService.removeProductFromCart(productId);
    }

    @GetMapping
    public List<ProductDTO> getAllProductsFromCart() {
        return cartService.getAllProductsFromCart();
    }
}
