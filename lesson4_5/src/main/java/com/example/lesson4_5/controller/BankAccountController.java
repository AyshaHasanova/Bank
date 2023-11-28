package com.example.lesson4_5.controller;


import com.example.lesson4_5.model.dto.BankAccountDto;
import com.example.lesson4_5.service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("bank-accounts/")
@AllArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;


    @GetMapping
    // @RequestMapping(name = "card", method = RequestMethod.GET, path = "card")
    public ResponseEntity<List<BankAccountDto>> getCardList() {
        return ResponseEntity.ok(bankAccountService.getBankAccountList());
    }

    @PostMapping
    public ResponseEntity<Void> createCard(@RequestBody BankAccountDto bankAccountDto) {
        bankAccountService.createBankAccount(bankAccountDto);
        return ResponseEntity.ok().build();
    }
}

