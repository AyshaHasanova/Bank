package com.example.lesson4_5.dao.repository;

import com.example.lesson4_5.dao.entity.BankEntity;
import com.example.lesson4_5.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankRepository extends JpaRepository<BankEntity, Long> {
    List<BankEntity> findAllByIdIn(List<Long> idList);
}
