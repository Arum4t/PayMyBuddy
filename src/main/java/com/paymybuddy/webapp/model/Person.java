package com.paymybuddy.webapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;


@Data
@Entity
@Table(name = "Person")
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Integer idPerson;

    @Column(name = "email", unique = true, nullable = false)
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    @JsonManagedReference
    private List<Contact> personList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    @JsonManagedReference
    private List<Contact> contactList;

}
