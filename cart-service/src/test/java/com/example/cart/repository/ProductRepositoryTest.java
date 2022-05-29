package com.example.cart.repository;

import com.example.cart.domain.Cart;
import com.example.cart.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    private final CartRepository cartRepository;
    private final TestEntityManager entityManager;

    @Autowired
    public ProductRepositoryTest(CartRepository cartRepository, TestEntityManager entityManager) {
        this.cartRepository = cartRepository;
        this.entityManager = entityManager;
    }

    @Test
    void createGetandDeleteCartTest() {
        assertThat(cartRepository).isNotNull();
        assertThat(entityManager).isNotNull();

        Cart cart = new Cart(TestUtil.getTestCart());
        entityManager.persist(cart);
        entityManager.flush();

        Optional<Cart> retrievedCart = cartRepository.findById(cart.getProductId());
        assertThat(retrievedCart).isPresent();

        assertThat(retrievedCart.get().getProductId())
                .isEqualTo(cart.getProductId());

        entityManager.remove(retrievedCart.get());
        entityManager.flush();

        Optional<Cart> removedCart = cartRepository.findById(cart.getProductId());

        assertThat(removedCart).isEmpty();
    }


}
