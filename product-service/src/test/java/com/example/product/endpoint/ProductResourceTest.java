package com.example.product.endpoint;

import com.example.product.model.ProductDTO;
import com.example.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Optional;

import static com.example.product.util.TestUtil.TEST_PRODUCT_ID;
import static com.example.product.util.TestUtil.getTestProduct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ActiveProfiles("testing")
@WebMvcTest(ProductResource.class)
public class ProductResourceTest {
    private MockMvc mvc;
    @MockBean
    private ProductService productService;

    @Autowired
    public ProductResourceTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    void getAllProducts() throws Exception {
        assertThat(mvc).isNotNull();
        assertThat(productService).isNotNull();

        ProductDTO testProduct = new ProductDTO(getTestProduct());
        testProduct.setId(TEST_PRODUCT_ID);

        when(productService.getAllProducts()).thenReturn(Collections.singletonList(testProduct));

        mvc.perform(MockMvcRequestBuilders.get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].id").value(testProduct.getId()))
                .andExpect(jsonPath("$[0].name").value(testProduct.getName()))
                .andExpect(jsonPath("$[0].price").value(testProduct.getPrice()));
    }

    @Test
    void getProductByIdNotFound() throws Exception {
        assertThat(mvc).isNotNull();
        assertThat(productService).isNotNull();
        when(productService.getProductById(anyLong())).thenReturn(Optional.empty());

        mvc.perform(MockMvcRequestBuilders.get("/products/"+TEST_PRODUCT_ID)
                .contentType(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
