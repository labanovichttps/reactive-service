package com.labanovich.user.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {

    private final Class<?> clazz;
    private final Object fieldValue;
    private final String fieldName;

    public EntityNotFoundException(String fieldName, Class<?> clazz, Object fieldValue) {
        super(String.format("%s with %s equal %s not found", clazz.getSimpleName(), fieldName, fieldValue));
        this.clazz = clazz;
        this.fieldValue = fieldValue;
        this.fieldName = fieldName;
    }
}
