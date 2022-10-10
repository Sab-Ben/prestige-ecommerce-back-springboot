package com.prestige.ecommerce.dao;

import com.prestige.ecommerce.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository <Produit, Integer> {

    Page<Produit> findByCategorieId(@Param("id") Integer id, Pageable pageable);

    Page<Produit> findByNomProduitContaining(@Param("nomProduit") String nomProduit, Pageable page);
}
