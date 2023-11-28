package com.example.lesson4_5.service;

import com.example.lesson4_5.dao.entity.UserEntity;
import com.example.lesson4_5.dao.repository.UserRepository;
import com.example.lesson4_5.mapper.BankMapper2;
//import com.example.lesson4_5.mapper.UserMapper;
import com.example.lesson4_5.model.dto.BankRequestDto;
import com.example.lesson4_5.model.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import com.example.lesson4_5.dao.entity.BankEntity;
import com.example.lesson4_5.dao.repository.BankRepository;
import com.example.lesson4_5.mapper.BankMapper;
import com.example.lesson4_5.model.dto.BankDto;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BankService {
    private final BankRepository bankRepository;
    private final UserRepository userRepository;
    private final BankMapper2 bankMapper;

    public List<BankDto> getBankList() {
        List<BankEntity> bankEntities = bankRepository.findAll();
        return bankMapper.toBankDtoList(bankEntities);
    }

    public void createBank(BankRequestDto bankDto) {
        BankEntity bankEntity = bankMapper.toBankEntity(bankDto);
        if (!bankDto.getUserIdList().isEmpty()) {
            List<UserEntity> existUsers = userRepository.findAllByIdIn(bankDto.getUserIdList());
            bankEntity.setUserEntityList(existUsers);
        }
        bankRepository.save(bankEntity);
    }

    public List<UserDto> findBankUserList(Long id) {
        Optional<BankEntity> bankEntity = bankRepository.findById(id);
        if (bankEntity.isPresent()) {
            return bankMapper.toUserDtoList(bankEntity.get().getUserEntityList());
        }
        return Collections.emptyList();
    }

/*
    public void createBank(BankDto bankDto) {
        BankEntity bankEntity = BankMapper.toBankEntity(bankDto);
        bankRepository.save(bankEntity);
        List<UserEntity> userEntityList = bankEntity.getUserEntityList();
        for (UserEntity userEntity:userEntityList) {
            userEntity.getBankEntities().add(bankEntity);
            userRepository.save(userEntity);
        }
    }



 */


}
