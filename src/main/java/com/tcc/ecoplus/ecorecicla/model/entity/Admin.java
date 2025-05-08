package com.tcc.ecoplus.ecorecicla.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "ADMIN")
public class Admin extends Usuario{

}
