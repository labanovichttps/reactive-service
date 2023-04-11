package com.labanovich.user.mapper;

import com.labanovich.user.dto.UserCreateDto;
import com.labanovich.user.dto.UserDto;
import com.labanovich.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    User toUser(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    User toUser(UserCreateDto createDto);

    UserDto toUserDto(User user);
}
