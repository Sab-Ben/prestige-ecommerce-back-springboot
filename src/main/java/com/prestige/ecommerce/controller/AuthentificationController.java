package com.prestige.ecommerce.controller;

import com.prestige.ecommerce.dto.Authentification;
import com.prestige.ecommerce.dto.AuthentificationReponse;
import com.prestige.ecommerce.service.AuthentificationService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/connexion")
public class AuthentificationController {


    private AuthentificationService authentificationService;

    public AuthentificationController  (AuthentificationService authentificationService) {
        this.authentificationService =  authentificationService;
    }

    @PostMapping("/success")
    public AuthentificationReponse connexionSuccessMessage (@RequestBody Authentification authentification) {
        AuthentificationReponse authentificationReponse = authentificationService.connexionSuccessMessage(authentification);

        return authentificationReponse;
    }
}


