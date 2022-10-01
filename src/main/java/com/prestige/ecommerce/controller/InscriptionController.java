package com.prestige.ecommerce.controller;


import com.prestige.ecommerce.dto.Inscription;
import com.prestige.ecommerce.dto.InscriptionReponse;
import com.prestige.ecommerce.service.InscriptionService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/inscription")
public class InscriptionController {

    private InscriptionService inscriptionService;

    public InscriptionController (InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping("/save")
    public InscriptionReponse confirmationInscription (@RequestBody Inscription inscription) {
        InscriptionReponse inscriptionReponse = inscriptionService.confirmationInscription(inscription);

        return inscriptionReponse;
    }
}
