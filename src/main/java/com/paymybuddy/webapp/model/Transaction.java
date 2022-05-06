package com.paymybuddy.webapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "account_Wallet", unique = true, nullable = false)
    private int account_Wallet;

    @Column(name = "account", nullable = false)
    private String type;

    @Column(name = "amount", nullable = false)
    private float amount;
}
