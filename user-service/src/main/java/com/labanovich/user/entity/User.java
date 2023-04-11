package com.labanovich.user.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Table("users")
public class User {

    @Id
    private Long id;

    private String username;

    private BigDecimal balance;
}
