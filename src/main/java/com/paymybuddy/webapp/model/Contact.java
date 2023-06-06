package com.paymybuddy.webapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idListContact;

    @ManyToOne
    @JoinColumn(name = "id_person")
    @JsonBackReference
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_contact")
    @JsonBackReference
    private Person contact;
}
