package com.paymybuddy.webapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Wallet")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wallet")
    private Integer idWallet;

    @Column(name = "amount_wallet", nullable = false)
    private float amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    private Person idPerson;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "walletEmitter")
    @JsonManagedReference
    private List<Transaction> emitterPersonListOperation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "walletReceiver")
    @JsonManagedReference
    private List<Transaction> receiverPersonListOperation;
}
