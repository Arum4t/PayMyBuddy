package com.paymybuddy.webapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "Person")
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person", nullable = false)
    private int id_person;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

   /*@ManyToMany
    @JoinTable(
            name="person_friend",
            joinColumns = @JoinColumn(name="id_person"),
            inverseJoinColumns = @JoinColumn(name="id_friend"))
    private Set<Friend> friends;*/
}
