package com.prestige.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Set;

@AllArgsConstructor
@Getter
public class AuthentificationReponse {

    private final String connexionSuccessMessage;
    private final CompteReponse utilisateur;
    private final Set<CommandeReponse> commandes;
    private final Set<AdresseReponse> adresses;

}
