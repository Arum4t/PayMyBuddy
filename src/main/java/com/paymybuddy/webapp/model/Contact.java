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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", insertable=false, updatable = false)
    @JsonBackReference
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", insertable=false, updatable = false)
    @JsonBackReference
    private Person contact;
}
