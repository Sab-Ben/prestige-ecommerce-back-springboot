package com.prestige.ecommerce.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "commande")
@Getter
@Setter
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_suivi_commande")
    private String numeroSuiviCommande;

    @Column(name = "total_prix")
    private int totalPrix;

    @Column(name = "total_quantite")
    private int totalQuantite;

    @Column(name = "statuts")
    private String statuts;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Set<CommandeItem> commandeItems = new HashSet<>();

    public void add(CommandeItem item) {

        if(item != null) {
            if(commandeItems == null) {
                commandeItems = new HashSet<>();
            }

            commandeItems.add(item);
            item.setCommande(this);
        }
    }
}
