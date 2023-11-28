package com.example.lesson4_5.service;

import com.example.lesson4_5.dao.entity.BankEntity;
import com.example.lesson4_5.dao.entity.UserEntity;
import com.example.lesson4_5.dao.repository.BankRepository;
import com.example.lesson4_5.dao.repository.UserRepository;
//import com.example.lesson4_5.mapper.UserMapper;
import com.example.lesson4_5.mapper.BankMapper2;
import com.example.lesson4_5.model.dto.UserDto;
import com.example.lesson4_5.model.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final BankMapper2 bankMapper;
    private final BankRepository bankRepository;

    public void createUser(UserRequestDto userRequestDto){
        UserEntity userEntity = bankMapper.toUserEntity(userRequestDto);
        if (! userRequestDto.getBankIdList().isEmpty()) {
            List<BankEntity> existBanks = bankRepository.findAllByIdIn(userRequestDto.getBankIdList());
            userEntity.setBankEntities(existBanks);
        }
        userRepository.save(userEntity);
    }
}
