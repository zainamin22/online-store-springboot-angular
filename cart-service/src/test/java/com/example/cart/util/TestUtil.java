package com.example.cart.util;

import com.example.cart.model.CartDTO;
import com.example.cart.model.ProductDTO;

public class TestUtil {
    public static final long TEST_PRODUCT_ID = 1;
    public static final String TEST_PRODUCT_NAME = "testProduct";
    public static final double TEST_PRICE = 700;

    public static CartDTO getTestCart () {
        return new CartDTO(TEST_PRODUCT_ID);
    }

    public static ProductDTO getTestProduct() {
        return new ProductDTO(TEST_PRODUCT_ID,TEST_PRODUCT_NAME, TEST_PRICE);
    }

}
