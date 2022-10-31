package com.prestige.ecommerce.controller;

import com.prestige.ecommerce.dto.Authentification;
import com.prestige.ecommerce.dto.AuthentificationReponse;
import com.prestige.ecommerce.service.AuthentificationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("https://localhost:4200")
@RestController
@RequestMapping("/api/connexion")
public class AuthentificationController {


    private AuthentificationService authentificationService;

    public AuthentificationController  (AuthentificationService authentificationService) {
        this.authentificationService =  authentificationService;
    }

    @PostMapping("/success")
    public AuthentificationReponse connexionSuccessMessage (@Valid @RequestBody Authentification authentification) {
        AuthentificationReponse authentificationReponse = authentificationService.connexionSuccessMessage(authentification);

        return authentificationReponse;
    }
}


