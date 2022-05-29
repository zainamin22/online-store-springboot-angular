package com.example.cart.endpoint;

import com.example.cart.domain.Cart;
import com.example.cart.endpoint.CartResource;
import com.example.cart.model.CartDTO;
import com.example.cart.model.ProductDTO;
import com.example.cart.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static com.example.cart.util.TestUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(CartResource.class)
public class CartResourceTest {
    private final MockMvc mvc;

    @MockBean
    private CartService cartService;

    @Autowired
    public CartResourceTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    void addProductInCartTest() throws Exception {
        assertThat(mvc).isNotNull();
        assertThat(cartService).isNotNull();

        CartDTO testCart = getTestCart();

        when(cartService.addProductInCart(any())).thenReturn(new Cart(testCart));

        mvc.perform(MockMvcRequestBuilders.post("/cart/products").
                        content("{\"productId\":" + testCart.getProductId() + "}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("$.productId").value(testCart.getProductId()));
    }


    @Test
    void deleteProductFromCartTest() throws Exception {
        assertThat(mvc).isNotNull();
        assertThat(cartService).isNotNull();
        doNothing().when(cartService).removeProductFromCart(anyLong());

        mvc.perform(MockMvcRequestBuilders.delete("/cart/products/" + TEST_PRODUCT_ID))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }


    @Test
    void getAllProductsFromCartTest() throws Exception {
        assertThat(mvc).isNotNull();
        assertThat(cartService).isNotNull();
        ProductDTO testProduct = getTestProduct();

        when(cartService.getAllProductsFromCart()).thenReturn(Collections.singletonList(testProduct));

        mvc.perform(MockMvcRequestBuilders.get("/cart/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].id").value(testProduct.getId()))
                .andExpect(jsonPath("$[0].name").value(testProduct.getName()))
                .andExpect(jsonPath("$[0].price").value(testProduct.getPrice()));
    }

}
