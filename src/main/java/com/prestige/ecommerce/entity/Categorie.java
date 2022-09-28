package com.prestige.ecommerce.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categorie")
@Getter
@Setter
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_categorie")
    private String nomCategorie;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private List<Produit> produit;


}
