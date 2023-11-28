package com.example.lesson4_5.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank_name", nullable = false, unique = true)
    private String bankName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "bank_users",
            joinColumns = @JoinColumn(name = "bank_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> userEntityList;

}
