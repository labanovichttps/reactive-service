package com.labanovich.order.service;

import com.labanovich.order.dto.OrderCreateDto;
import com.labanovich.order.dto.OrderDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {

    Flux<OrderDto> findAll();
    Mono<OrderDto> createOrder(Mono<OrderCreateDto> orderCreateDto);
}
