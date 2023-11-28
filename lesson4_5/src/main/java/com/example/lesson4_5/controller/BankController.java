package com.example.lesson4_5.controller;

import com.example.lesson4_5.model.dto.BankAccountDto;
import com.example.lesson4_5.model.dto.BankDto;
import com.example.lesson4_5.model.dto.BankRequestDto;
import com.example.lesson4_5.model.dto.UserDto;
import com.example.lesson4_5.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("banks/")
@AllArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping
    public ResponseEntity<List<BankDto>> getBankList() {
        return ResponseEntity.ok(bankService.getBankList());
    }

    @PostMapping
    public ResponseEntity<Void> createBank(@RequestBody BankRequestDto bankRequestDto) {
        bankService.createBank(bankRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/users")
    public ResponseEntity<List<UserDto>> getBankUsers(@PathVariable Long id) {
        return ResponseEntity.ok(bankService.findBankUserList(id));
    }
}
