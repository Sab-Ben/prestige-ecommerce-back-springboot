package com.prestige.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@AllArgsConstructor
@Getter
public class CommandeReponse {

    private String numeroSuiviCommande;

    private int totalPrix;

    private int totalQuantite;

    @CreationTimestamp
    private Date date;
}
