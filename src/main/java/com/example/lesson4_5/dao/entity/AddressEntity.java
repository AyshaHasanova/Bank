package com.example.lesson4_5.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;

    @OneToOne(mappedBy = "addressEntity")
    private UserEntity userEntity;

}
