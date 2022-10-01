package com.prestige.ecommerce.service;

import com.prestige.ecommerce.dao.UtilisateurRepository;
import com.prestige.ecommerce.dto.*;
import com.prestige.ecommerce.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationServiceImpl implements AuthentificationService{

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public AuthentificationServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public AuthentificationReponse connexionSuccessMessage(Authentification authentification) {

        Utilisateur utilisateur = authentification.getUtilisateur();

        String connexionSuccessMessage = connexion();
        utilisateur.getMotDePasse();


        if (utilisateur.getEmail() == null) {

        }

        return new AuthentificationReponse(connexionSuccessMessage);
    }

    private String connexion() {
        return utilisateurRepository.findByEmail(toString()).getEmail();
    }

}
