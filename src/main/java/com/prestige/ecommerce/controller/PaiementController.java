package com.prestige.ecommerce.controller;


import com.prestige.ecommerce.dto.Achat;
import com.prestige.ecommerce.dto.AchatReponse;
import com.prestige.ecommerce.service.PaiementService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/paiement")
public class PaiementController {

    private PaiementService paiementService;


    public PaiementController (PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @PostMapping("/achat")
    public AchatReponse passerCommande (@Valid @RequestBody Achat achat) {
        AchatReponse achatReponse = paiementService.passerCommande(achat);

        return achatReponse;
    }
}
