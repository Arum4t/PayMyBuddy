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

    @Column(name = "id_wallet_emitter", nullable = false)
    private Integer idWalletEmitter;

    @Column(name = "id_wallet_receiver", nullable = false)
    private Integer idWalletReceiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wallet", insertable=false, updatable = false)
    @JsonBackReference
    private Wallet walletEmitter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wallet", insertable=false, updatable = false)
    @JsonBackReference
    private Wallet walletReceiver;


}
