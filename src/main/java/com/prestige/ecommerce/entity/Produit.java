package com.prestige.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "produit")
@Data
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom_produit")
    private String nomProduit;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "stock")
    private int stock;

    @Column(name = "prix")
    private int prix;

    @Column(name = "disponible")
    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;




}
