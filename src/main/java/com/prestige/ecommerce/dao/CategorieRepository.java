package com.prestige.ecommerce.dao;

import com.prestige.ecommerce.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "categorie", path = "categorie")
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
