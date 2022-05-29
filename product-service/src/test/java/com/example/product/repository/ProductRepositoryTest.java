package com.example.product.repository;

import com.example.product.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static com.example.product.util.TestUtil.getTestProduct;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("testing")
@DataJpaTest
public class ProductRepositoryTest {

    private final ProductRepository productRepository;
    private final TestEntityManager entityManager;

    @Autowired
    public ProductRepositoryTest(ProductRepository productRepository, TestEntityManager entityManager) {
        this.productRepository = productRepository;
        this.entityManager = entityManager;
    }

    @Test
    void createAndGetProductTest() {
        assertThat(productRepository).isNotNull();
        assertThat(entityManager).isNotNull();

        Product product = getTestProduct();
        entityManager.persist(product);
        entityManager.flush();

        assertThat(product.getId())
                .isNotNull();

        Product testProduct = productRepository.findById(product.getId()).orElse(new Product());

        assertThat(testProduct.getId())
                .isEqualTo(product.getId());

        assertThat(testProduct.getName())
                .isEqualTo(product.getName());

        assertThat(testProduct.getPrice())
                .isEqualTo(product.getPrice());
    }


}
