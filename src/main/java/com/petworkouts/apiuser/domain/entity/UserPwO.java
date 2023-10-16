package com.petworkouts.apiuser.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "UserPwO")
@Getter
@Setter
public class UserPwO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

}
