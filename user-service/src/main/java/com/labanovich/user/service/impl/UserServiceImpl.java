package com.labanovich.user.service.impl;

import com.labanovich.user.dto.UserCreateDto;
import com.labanovich.user.dto.UserDto;
import com.labanovich.user.mapper.UserMapper;
import com.labanovich.user.repository.UserRepository;
import com.labanovich.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Mono<UserDto> findById(Long id) {
        return userRepository.findById(id)
            .map(userMapper::toUserDto);
    }

    @Override
    @Transactional
    public Mono<UserDto> save(Mono<UserCreateDto> createDto) {
        return createDto.map(userMapper::toUser)
            .flatMap(userRepository::save)
            .map(userMapper::toUserDto);
    }
}
