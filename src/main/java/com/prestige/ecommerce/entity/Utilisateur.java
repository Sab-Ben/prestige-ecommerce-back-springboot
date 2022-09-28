package com.prestige.ecommerce.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "telephone")
    private int telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Set<Commande> commandes = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Set<Adresse> adresses =  new HashSet<>();

    public void add(Commande commande) {

        if(commande != null) {
            if(commandes == null) {
               commandes = new HashSet<>();
            }

            commandes.add(commande);
            commande.setUtilisateur(this);
        }
    }

    public void addAdresse(Adresse adresse) {

        if(adresse != null) {
            if(adresses == null) {
                adresses = new HashSet<>();
            }

            adresses.add(adresse);
            adresse.setUtilisateur(this);
        }
    }
}
