package com.example.lesson4_5.mapper;

import com.example.lesson4_5.dao.entity.BankEntity;
import com.example.lesson4_5.model.dto.BankDto;
import com.example.lesson4_5.model.dto.BankRequestDto;

import java.util.List;
import java.util.stream.Collectors;

public class BankMapper {

    public static BankDto toBankDto(BankEntity bankEntity) {
        return BankDto.builder()
                .id(bankEntity.getId())
                .name(bankEntity.getBankName())
                .build();
    }

    public static BankEntity toBankEntity(BankDto bankDto) {
        return BankEntity.builder()
                .id(bankDto.getId())
                .bankName(bankDto.getName())
                .build();
    }
    public static BankEntity toBankEntity(BankRequestDto bankDto) {
        return BankEntity.builder()
                .bankName(bankDto.getBankName())
                .build();
    }

    public static List<BankDto> toBankDtoList(List<BankEntity> bankEntities) {
        return bankEntities.stream().map(BankMapper::toBankDto).collect(Collectors.toList());
    }
}
