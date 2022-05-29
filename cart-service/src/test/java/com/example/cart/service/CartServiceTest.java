package com.example.cart.service;

import com.example.cart.domain.Cart;
import com.example.cart.external.service.ProductService;
import com.example.cart.model.CartDTO;
import com.example.cart.model.ProductDTO;
import com.example.cart.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Optional;

import static com.example.cart.util.TestUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = CartService.class)
public class CartServiceTest {
    private final CartService cartService;
    @MockBean
    private CartRepository cartRepository;

    @MockBean
    private ProductService productService;

    @Autowired
    public CartServiceTest(CartService cartService) {
        this.cartService = cartService;
    }

    @Test
    void addCartProductTest() {
        assertThat(cartRepository).isNotNull();
        assertThat(cartService).isNotNull();

        Cart testCart = new Cart(getTestCart());

        when(cartRepository.findAll()).thenReturn(Collections.singletonList(testCart));
        when(cartRepository.findById(anyLong())).thenReturn(Optional.of(testCart));

        Cart resultCart = cartService.addProductInCart(new CartDTO(testCart));
        assertThat(testCart.getProductId()).isEqualTo(resultCart.getProductId());

    }

    @Test
    public void removeProductFromCartNotFoundTest() {
        assertThat(cartRepository).isNotNull();
        assertThat(cartService).isNotNull();

        when(cartRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> {
            cartService.removeProductFromCart(TEST_PRODUCT_ID);
        });
    }

    @Test
    public void getAllProductsFromCartTest() {
        assertThat(cartRepository).isNotNull();
        assertThat(cartService).isNotNull();
        assertThat(productService).isNotNull();

        Cart testCart = new Cart(getTestCart());
        when(cartRepository.findAll()).thenReturn(Collections.singletonList(testCart));

        ProductDTO testProduct = getTestProduct();

        when(productService.getProductById(anyLong())).thenReturn(testProduct);

        ProductDTO resultProduct = cartService.getAllProductsFromCart().get(0);
        assertThat(testCart.getProductId()).isEqualTo(resultProduct.getId());
    }
}
