package com.prestige.ecommerce.service;

import com.prestige.ecommerce.dto.Achat;
import com.prestige.ecommerce.dto.AchatReponse;

public interface PaiementService {

    AchatReponse passerCommande(Achat achat);
}
