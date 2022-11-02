package com.prestige.ecommerce.service;

import com.prestige.ecommerce.dao.UtilisateurRepository;
import com.prestige.ecommerce.dto.Achat;
import com.prestige.ecommerce.dto.AchatReponse;
import com.prestige.ecommerce.entity.Adresse;
import com.prestige.ecommerce.entity.Commande;
import com.prestige.ecommerce.entity.CommandeItem;
import com.prestige.ecommerce.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class PaiementServiceImpl implements PaiementService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public PaiementServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    @Transactional
    public AchatReponse passerCommande(Achat achat) {

        Commande commande = achat.getCommande();

        String numeroSuiviCommande = generateNumeroSuiviCommande();
        commande.setNumeroSuiviCommande(numeroSuiviCommande);

        Set<CommandeItem> commandeItems = achat.getCommandeItems();
        commandeItems.forEach(item -> commande.add(item));

        Adresse adresse = achat.getAdresse();

        Utilisateur utilisateur = achat.getUtilisateur();
        String email = utilisateur.getEmail();
        Utilisateur utilisateurExiste = userExisting(email);

        utilisateurExiste.add(commande);
        utilisateurExiste.addAdresse(adresse);

        utilisateurRepository.flush();

        return new AchatReponse(numeroSuiviCommande);
    }

    private String generateNumeroSuiviCommande() {return UUID.randomUUID().toString();}

    private Utilisateur userExisting(String email) {

        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) {
            throw new UtilisateurNotFoundException("L'utilisateur n'existe pas pour ce mail " + email);
        }
        return utilisateur;
    }
}
