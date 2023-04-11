package com.labanovich.user.service;

import com.labanovich.user.dto.UserCreateDto;
import com.labanovich.user.dto.UserDto;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserDto> findById(Long id);

    Mono<UserDto> save(Mono<UserCreateDto> createDto);
}
