package com.labanovich.order.client;

import com.labanovich.order.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserClient {

    private final WebClient webClient;

    @Value("${app.user-service.host}")
    private String userServiceHost;

    public Mono<UserDto> getUser(Long id) {
        return webClient
                .get()
                .uri(userServiceHost + "/users" + "/{id}", id)
                .retrieve()
                .bodyToMono(UserDto.class);
    }
}
