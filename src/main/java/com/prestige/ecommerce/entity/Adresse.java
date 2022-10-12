package com.prestige.ecommerce.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "adresse")
@Getter
@Setter
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom_adresse")
    private String nom_adresse;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "complement_adresse")
    private String complement_adresse;

    @Column(name = "code_postale")
    private String code_postale;

    @Column(name = "ville")
    private String ville;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

}
