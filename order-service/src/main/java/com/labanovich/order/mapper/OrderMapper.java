package com.labanovich.order.mapper;

import com.labanovich.order.dto.OrderDto;
import com.labanovich.order.dto.ProductDto;
import com.labanovich.order.dto.UserDto;
import com.labanovich.order.entity.Order;
import com.labanovich.order.type.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;

@Mapper(uses = OrderStatus.class)
public interface OrderMapper {

    OrderDto toOrderDto(Order order);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", source = "userDto.id")
    @Mapping(target = "status", expression = "java(OrderStatus.ACCEPTED)")
    @Mapping(target = "productId", source = "productDto.id")
    @Mapping(target = "acceptedTime", expression = "java(Instant.now())")
    Order toOrder(UserDto userDto, ProductDto productDto);
}
