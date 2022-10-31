package com.prestige.ecommerce.dto;

import com.prestige.ecommerce.entity.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class AuthentificationReponse {

    private final String connexionSuccessMessage;
    private final UtilisateurReponse utilisateur;
    private final Set<CommandeReponse> commandes;
    private final Set<AdresseReponse> adresses;

}
