package com.prestige.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.Email;


@AllArgsConstructor
@Getter
public class UtilisateurReponse {

    private String nom;

    private String prenom;

    @Email
    private String email;

    private int telephone;


}
