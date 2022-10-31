package com.prestige.ecommerce.dto;

import com.prestige.ecommerce.entity.Utilisateur;
import lombok.Data;

@Data
public class AuthentificationReponse {

    private final String connexionSuccessMessage;
    private final Utilisateur utilisateur;

}
