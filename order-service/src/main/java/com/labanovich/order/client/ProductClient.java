package com.labanovich.order.client;

import com.labanovich.order.dto.ProductDto;
import com.labanovich.order.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductClient {

    private final WebClient webClient;

    @Value("${app.product-service.host}")
    private String productServiceHost;

    public Mono<ProductDto> getProduct(String id) {
        return webClient
                .get()
                .uri(productServiceHost + "/products" + "/{id}", id)
                .retrieve()
                .bodyToMono(ProductDto.class);
    }
}
