package com.labanovich.user.dto;

import java.math.BigDecimal;

public record UserCreateDto(String username,
                            BigDecimal balance) {
}
