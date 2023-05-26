package com.example.lesson4_5.mapper;

import com.example.lesson4_5.dao.entity.BankAccountEntity;
import com.example.lesson4_5.model.dto.BankAccountDto;
import com.example.lesson4_5.model.dto.CardDto;

import java.util.ArrayList;
import java.util.List;

public class BankAccountMapper {
    public static BankAccountDto toBankAccountDto(BankAccountEntity bankAccountEntity) {
        return BankAccountDto.builder()
                .id(bankAccountEntity.getId())
                .iban(bankAccountEntity.getIban())
                .build();
    }

    public static BankAccountEntity toBankAccountEntity(BankAccountDto bankAccountDto) {
        return BankAccountEntity.builder()
                .id(bankAccountDto.getId())
                .iban(bankAccountDto.getIban())
                .build();
    }

    public static List<BankAccountDto> toBankAccountDtoList(List<BankAccountEntity> bankAccountEntities) {
        List<BankAccountDto> bankAccountDtos = new ArrayList<>();
        for (BankAccountEntity bankAccountEntity : bankAccountEntities) {
            BankAccountDto bankAccountDto = toBankAccountDto(bankAccountEntity);
            bankAccountDtos.add(bankAccountDto);
        }
        return bankAccountDtos;
    }



}
