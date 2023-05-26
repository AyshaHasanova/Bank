package com.example.lesson4_5.mapper;

import com.example.lesson4_5.dao.entity.UserEntity;
import com.example.lesson4_5.model.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto toUserDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .build();
    }

    public static List<UserDto> toUserDtoList(List<UserEntity> userEntityList) {
        return userEntityList.stream().map(UserMapper::toUserDto).collect(Collectors.toList());
    }

    public static UserEntity toUserEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .build();
    }

    public static List<UserEntity> toUserEntityList(List<UserDto> userDtos) {
        List<UserEntity> userEntityList = new ArrayList<>();
        for (UserDto userDto : userDtos) {
            UserEntity userEntity = toUserEntity(userDto);
            userEntityList.add(userEntity);
        }
        return userEntityList;
    }
}
