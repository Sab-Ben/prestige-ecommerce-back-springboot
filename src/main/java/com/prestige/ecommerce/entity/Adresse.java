package com.prestige.ecommerce.entity;

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
    private String nomAdresse;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "code_postale")
    private int codePostale;

    @Column(name = "ville")
    private String ville;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

}
