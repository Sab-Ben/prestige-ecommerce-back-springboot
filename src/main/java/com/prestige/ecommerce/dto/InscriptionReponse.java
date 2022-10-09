package com.prestige.ecommerce.dto;

import com.prestige.ecommerce.entity.Utilisateur;
import lombok.Data;

@Data
public class InscriptionReponse {

    private final Utilisateur confirmationInscription;
}
