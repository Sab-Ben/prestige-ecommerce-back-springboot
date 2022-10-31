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

        String email = utilisateur.getEmail();
        Utilisateur userSuccess = userExisting(email);

        return new AuthentificationReponse(userSuccess.getEmail(), userSuccess);
    }

    private Utilisateur userExisting(String email) {

        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) {
            throw new UtilisateurNotFoundException("L'utilisateur n'existe pas pour ce mail " + email);
        }
        return utilisateur;
    }

}
