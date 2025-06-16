package com.tcc.ecoplus.ecorecicla.model.entity;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "REPRESENTANTECOLETORA")
public class RepresentanteColetora extends Usuario {

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "geradora_id", referencedColumnName = "id", nullable = true)
    private Geradora geradora;


    public Geradora getGeradora() {
        return geradora;
    }

    public void setGeradora(Geradora geradora) {
        this.geradora = geradora;
    }
}
