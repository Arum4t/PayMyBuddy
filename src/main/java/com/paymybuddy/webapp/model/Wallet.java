package com.paymybuddy.webapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "amount", nullable = false)
    private float amount;

    @Column(name = "id_Person", nullable = false)
    private int id_Person;

    @Column(name = "account", unique = true, nullable = false)
    private int account;
}
