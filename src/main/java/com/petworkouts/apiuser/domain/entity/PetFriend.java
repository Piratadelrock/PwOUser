package com.petworkouts.apiuser.domain.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "PetFriend")
@Data
public class PetFriend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    // Atributos
    @Column(nullable = false)
    private String name;
    @Column
    private int age;
    @Column(nullable = false)
    private String breed;

// veremos si se implementa ya que puede pertenecer a los Canis lupus la especie de domesticos private String especie;
    @Column
    private String weight;
    @Column
    private String color;
    @Column
    private String behavior;

    @Column
    private String training;
    @Column
    private String health;




}
