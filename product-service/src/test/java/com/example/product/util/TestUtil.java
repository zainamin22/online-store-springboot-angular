package com.example.product.util;

import com.example.product.domain.Product;

public class TestUtil {
    public static final String TEST_PRODUCT_NAME = "testProduct";

    public static final long TEST_PRODUCT_ID = 1;
    public static final double TEST_PRICE = 700;

    public static Product getTestProduct() {
        return new Product(TEST_PRODUCT_NAME, TEST_PRICE);
    }
}
