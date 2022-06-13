package com.paymybuddy.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


@Data
@Entity
@Table(name = "Person")
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "emitterPersonId")
    private List<Transaction> emitterPersonListOperation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receiverPersonId")
    private List<Transaction> receiverPersonListOperation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<Contact> personListContact;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private List<Contact> contactListContact;

}
