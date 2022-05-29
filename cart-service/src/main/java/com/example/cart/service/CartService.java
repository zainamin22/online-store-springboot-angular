package com.example.cart.service;

import com.example.cart.domain.Cart;
import com.example.cart.external.service.ProductService;
import com.example.cart.model.CartDTO;
import com.example.cart.model.ProductDTO;
import com.example.cart.repository.CartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;

    public CartService(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    public Cart addProductInCart (CartDTO cart) {
        return cartRepository.findById(cart.getProductId())
                .orElseGet(() -> cartRepository.save(new Cart(cart)));
    }
    public void removeProductFromCart (Long productId) {
        cartRepository.delete
                (cartRepository.findById(productId).orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Product Not Present in Cart")));
    }

    public List<ProductDTO> getAllProductsFromCart() {
      return cartRepository.findAll().stream().map(cart ->
              productService.getProductById(cart.getProductId())).collect(Collectors.toList());
    }

}
