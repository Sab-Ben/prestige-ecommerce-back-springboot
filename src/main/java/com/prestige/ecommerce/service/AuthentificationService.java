package com.prestige.ecommerce.service;

import com.prestige.ecommerce.dto.Authentification;
import com.prestige.ecommerce.dto.AuthentificationReponse;

public interface AuthentificationService {

    AuthentificationReponse connexionSuccessMessage(Authentification authentification);
}
