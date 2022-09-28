package com.prestige.ecommerce.config;

import com.prestige.ecommerce.entity.Categorie;
import com.prestige.ecommerce.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod [] lesActionsNonActivees = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST};

        // configuration des actions put, delete, et post pour être désactivées
        config.getExposureConfiguration()
                .forDomainType(Produit.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(lesActionsNonActivees)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(lesActionsNonActivees)));

        config.getExposureConfiguration()
                .forDomainType(Categorie.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(lesActionsNonActivees)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(lesActionsNonActivees)));

        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // récupérer une liste de toutes les classes entités depuis entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // Créer un tableau de types entités
        List<Class> entityClasses = new ArrayList<Class>();

        // Récupérer l'entité type depuis les entitées
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // expose les identifiants des entités pour le tableau de types entités
        Class[ ] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }
}
