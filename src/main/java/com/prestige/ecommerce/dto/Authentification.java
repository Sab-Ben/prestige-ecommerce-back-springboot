package com.prestige.ecommerce.dto;

import com.prestige.ecommerce.entity.Utilisateur;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Authentification {

    @NotNull
    private Utilisateur utilisateur;
}
