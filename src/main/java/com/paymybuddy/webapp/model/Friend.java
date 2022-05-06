package com.paymybuddy.webapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Friend")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "id_Person", nullable = false)
    private int email_erson;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
}
