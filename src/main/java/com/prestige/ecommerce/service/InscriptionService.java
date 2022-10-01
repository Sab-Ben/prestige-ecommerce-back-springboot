package com.prestige.ecommerce.service;

import com.prestige.ecommerce.dto.Inscription;
import com.prestige.ecommerce.dto.InscriptionReponse;

public interface InscriptionService {
    InscriptionReponse confirmationInscription (Inscription inscription);
}
