package com.labanovich.user.controller;

import com.labanovich.user.dto.UserCreateDto;
import com.labanovich.user.dto.UserDto;
import com.labanovich.user.entity.User;
import com.labanovich.user.exception.EntityNotFoundException;
import com.labanovich.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Mono<UserDto>> findById(@PathVariable Long id) {
        log.info("id {}", id);
        return ResponseEntity.ok()
            .body(userService.findById(id)
                .switchIfEmpty(Mono.error(() -> new EntityNotFoundException("id", User.class, id))));
    }

    @PostMapping
    public ResponseEntity<Mono<UserDto>> save(@RequestBody Mono<UserCreateDto> userCreateDto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.save(userCreateDto));
    }
}
