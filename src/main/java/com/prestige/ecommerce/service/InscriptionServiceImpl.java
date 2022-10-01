package com.prestige.ecommerce.service;


import com.prestige.ecommerce.dao.UtilisateurRepository;
import com.prestige.ecommerce.dto.Inscription;
import com.prestige.ecommerce.dto.InscriptionReponse;
import com.prestige.ecommerce.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InscriptionServiceImpl implements InscriptionService{


    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public InscriptionServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public InscriptionReponse confirmationInscription(Inscription inscription) {

            Utilisateur utilisateur = inscription.getUtilisateur();

            assert utilisateur != null;
        Utilisateur utilisateurSauvegarder = utilisateurRepository.save(utilisateur);

        return new InscriptionReponse(utilisateurSauvegarder.getPrenom());
    }

}
