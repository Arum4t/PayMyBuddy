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

    @ManyToOne
    @JoinColumn(name = "account_wallet", unique = true, nullable = false)
    private Wallet account_Wallet;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "amount_transaction", nullable = false)
    private float amount_transaction;

}
