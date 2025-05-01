package com.tcc.ecoplus.ecorecicla.model.entity;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "REPRESENTANTECOLETORA")
public class RepresentanteColetora extends Usuario {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = true)
    private Geradora geradora;

    public Geradora getPessoaJuridica() {
        return geradora;
    }

    public void setPessoaJuridica(Geradora geradora) {
        this.geradora = geradora;
    }
}
