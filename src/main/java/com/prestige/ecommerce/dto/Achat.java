package com.prestige.ecommerce.dto;

import com.prestige.ecommerce.entity.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class Achat {

    @NotNull
    private Utilisateur utilisateur;
    @NotNull
    private Adresse adresse;
    @NotNull
    private Commande commande;
    @NotNull
    private Set<CommandeItem> commandeItems;
}
