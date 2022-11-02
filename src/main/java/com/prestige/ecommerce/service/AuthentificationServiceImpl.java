package com.prestige.ecommerce.service;

import com.prestige.ecommerce.dao.UtilisateurRepository;
import com.prestige.ecommerce.dto.*;
import com.prestige.ecommerce.entity.Utilisateur;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

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
        Utilisateur utilisateurExiste = userExisting(email);

        var utilisateurReponse = new UtilisateurReponse(utilisateurExiste.getNom(),
                utilisateurExiste.getPrenom(),
                utilisateurExiste.getEmail(),
                utilisateurExiste.getTelephone());

        Set<AdresseReponse> adresseReponses = utilisateurExiste.getAdresses().stream()
                .map(adresse -> new AdresseReponse(adresse.getNomAdresse(),
                        adresse.getAdresse(),
                        adresse.getCodePostale(),
                        adresse.getVille()))
                .collect(Collectors.toSet());

        Set<CommandeReponse> commandeReponses = utilisateurExiste.getCommandes().stream()
                .map(commande -> new CommandeReponse(commande.getNumeroSuiviCommande(),
                        commande.getTotalPrix(),
                        commande.getTotalQuantite(),
                        commande.getDate()))
                .collect(Collectors.toSet());

        return new AuthentificationReponse(utilisateurExiste.getEmail(), utilisateurReponse, commandeReponses, adresseReponses);
    }

    private Utilisateur userExisting(String email) {

        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) {
            throw new UtilisateurNotFoundException("L'utilisateur n'existe pas pour ce mail " + email);
        }
        return utilisateur;
    }
}
