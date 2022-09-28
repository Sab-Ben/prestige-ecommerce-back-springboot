package com.prestige.ecommerce.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "commande_item")
@Getter
@Setter
public class CommandeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

    @Column(name = "image")
     private String image;

    @Column(name = "prix")
     private int prix;

    @Column(name = "quantite")
     private int quantite;

    @ManyToOne
    @JoinColumn(name = "commande_id")
     private Commande commande;

}
