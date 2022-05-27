package com.paymybuddy.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Transaction")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "amount_transaction", nullable = false)
    private float amount_transaction;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_wallet")
    @JsonManagedReference
    private Wallet wallet;

}
