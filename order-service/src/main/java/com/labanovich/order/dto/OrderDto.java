package com.labanovich.order.dto;

import com.labanovich.order.type.OrderStatus;

import java.time.Instant;

public record OrderDto(Long id,
                       OrderStatus status,
                       Instant acceptedTime) {
}
