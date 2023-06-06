package com.paymybuddy.webapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Transaction")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Integer idTransaction;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "amount_transaction", nullable = false)
    private float amount;


    @ManyToOne
    @JoinColumn(name = "id_wallet_emitter")
    @JsonBackReference
    private Wallet walletEmitter;

    @ManyToOne
    @JoinColumn(name = "id_wallet_receiver")
    @JsonBackReference
    private Wallet walletReceiver;


}
