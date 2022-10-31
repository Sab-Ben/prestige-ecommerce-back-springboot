package com.prestige.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AdresseReponse {

    private String nomAdresse;

    private String adresse;

    private int codePostale;

    private String ville;
}
