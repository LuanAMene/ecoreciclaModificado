package com.tcc.ecoplus.ecorecicla.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "REPRESENTANTEDESTINADORA")
public class RepresentanteDestinadora extends Usuario {

}
