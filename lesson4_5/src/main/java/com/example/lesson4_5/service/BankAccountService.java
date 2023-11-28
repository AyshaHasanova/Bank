package com.example.lesson4_5.service;

import com.example.lesson4_5.dao.entity.BankAccountEntity;
import com.example.lesson4_5.dao.repository.BankAccountRepository;
import com.example.lesson4_5.mapper.BankAccountMapper;
import com.example.lesson4_5.model.dto.BankAccountDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    public List<BankAccountDto> getBankAccountList(){
        List<BankAccountEntity> bankAccountEntities = bankAccountRepository.findAll();
        return BankAccountMapper.toBankAccountDtoList(bankAccountEntities);
    }
    public void createBankAccount(BankAccountDto bankAccountDto){
        BankAccountEntity bankAccountEntity = BankAccountMapper.toBankAccountEntity(bankAccountDto);
        bankAccountRepository.save(bankAccountEntity);
    }

}
