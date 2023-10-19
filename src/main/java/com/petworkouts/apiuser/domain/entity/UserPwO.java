package com.petworkouts.apiuser.domain.entity;

import com.petworkouts.apiuser.domain.enums.PersonGender;
import com.petworkouts.apiuser.domain.enums.UserType;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "UserPwO")
public class UserPwO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document")
    private Integer personID;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @Enumerated(EnumType.STRING)
    private PersonGender gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "register_type")
    @Enumerated(EnumType.STRING)
    private UserType registerType;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

}
