package com.tcc.ecoplus.ecorecicla.model.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "REPRESENTANTEDESTINADORA")
public class RepresentanteDestinadora extends Usuario {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = true)
    private Destinadora destinadora;

    public Destinadora getDestinadora() {
        return destinadora;
    }

    public void setDestinadora(Destinadora destinadora) {
        this.destinadora = destinadora;
    }
}
