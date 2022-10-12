package com.prestige.ecommerce.dao;

import com.prestige.ecommerce.entity.Adresse;
import com.prestige.ecommerce.entity.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdresseRepository extends JpaRepository <Adresse, Integer> {

    Page<Adresse> findByUtilisateurId(@Param("id") String id, Pageable pageable);
}
