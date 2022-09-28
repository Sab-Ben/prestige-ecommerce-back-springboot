package com.prestige.ecommerce.dto;

import com.prestige.ecommerce.entity.*;
import lombok.Data;

import java.util.Set;

@Data
public class Achat {

    private Utilisateur utilisateur;
    private Adresse adresse;
    private Commande commande;
    private Set<CommandeItem> commandeItems;
}
