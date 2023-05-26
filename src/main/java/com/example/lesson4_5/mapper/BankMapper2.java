package com.example.lesson4_5.mapper;

import  com.example.lesson4_5.dao.entity.BankEntity;
import com.example.lesson4_5.model.dto.BankDto;
import com.example.lesson4_5.model.dto.BankRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankMapper2 {
    @Mapping(target = "name",source = "bankName")
    BankDto toBankDto(BankEntity bankEntity);

    BankEntity toBankEntity(BankDto bankDto);

    BankEntity toBankEntity(BankRequestDto bankDto);

    List<BankDto> toBankDtoList(List<BankEntity> bankEntities);

}
