package com.paymybuddy.webapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Wallet")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(name = "amount_wallet", nullable = false)
    private float amount_wallet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Person person;

    @Column(name = "account", unique = true, nullable = false)
    private int account;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wallet")
    @JsonBackReference
    private List<Transaction> transactions;

}
