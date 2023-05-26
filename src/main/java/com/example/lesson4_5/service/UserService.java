package com.example.lesson4_5.service;

import com.example.lesson4_5.dao.entity.UserEntity;
import com.example.lesson4_5.dao.repository.UserRepository;
import com.example.lesson4_5.mapper.UserMapper;
import com.example.lesson4_5.model.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserDto userDto){
        UserEntity userEntity = UserMapper.toUserEntity(userDto);
        userRepository.save(userEntity);
    }
}
