package com.labanovich.order.service.impl;

import com.labanovich.order.mapper.OrderMapper;
import com.labanovich.order.client.ProductClient;
import com.labanovich.order.client.UserClient;
import com.labanovich.order.dto.OrderCreateDto;
import com.labanovich.order.dto.OrderDto;
import com.labanovich.order.repository.OrderRepository;
import com.labanovich.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserClient userClient;
    private final ProductClient productClient;


    @Override
    public Flux<OrderDto> findAll() {
        return Flux.fromStream(orderRepository.findAll().stream())
                .map(orderMapper::toOrderDto);
    }

    @Override
    public Mono<OrderDto> createOrder(Mono<OrderCreateDto> orderCreateDto) {
        return orderCreateDto
                .flatMap(orderDto -> Mono.zip(userClient.getUser(orderDto.userId()),
                        productClient.getProduct(orderDto.productId())))
                .map(tuple -> orderMapper.toOrder(tuple.getT1(), tuple.getT2()))
                .map(orderRepository::save)
                .map(orderMapper::toOrderDto)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
