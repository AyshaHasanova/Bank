package com.example.lesson4_5.dao.repository;

import com.example.lesson4_5.dao.entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankEntity, Long> {

}
