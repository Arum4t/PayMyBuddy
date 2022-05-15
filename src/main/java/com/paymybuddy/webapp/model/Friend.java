package com.paymybuddy.webapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Friend")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_friend", nullable = false)
    private int id_friend;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    /*@ManyToMany
    @JoinTable(
            name="person_friend",
            joinColumns = @JoinColumn(name="id_friend"),
            inverseJoinColumns = @JoinColumn(name="id_person"))
    private Set<Person> persons;*/
}
