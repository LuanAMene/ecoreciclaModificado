package com.tcc.ecoplus.ecorecicla.model.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "REPRESENTANTEDESTINADORA")
public class RepresentanteDestinadora extends Usuario {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "destinadora_id", referencedColumnName = "id", nullable = true)
    private Destinadora destinadora;



    public Destinadora getDestinadora() {
        return destinadora;
    }

    public void setDestinadora(Destinadora destinadora) {
        this.destinadora = destinadora;
    }
}
