package com.example.product;

import com.example.product.domain.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Profile("!testing")
    @Bean
    ApplicationRunner initDatabase (ProductRepository repository) {
        return args -> IntStream.rangeClosed(1,20).mapToObj
                (val->new Product("Product".concat(String.valueOf(val)),
                (double) (val*100))).forEach(repository::save);
    }

}
