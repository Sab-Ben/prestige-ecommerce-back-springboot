package com.prestige.ecommerce.dto;

import com.prestige.ecommerce.entity.Adresse;
import com.prestige.ecommerce.entity.Commande;
import com.prestige.ecommerce.entity.Utilisateur;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Compte {

    @NotNull
    private Utilisateur utilisateur;
    
    private Adresse adresse;
    
    private Commande commande;
}
