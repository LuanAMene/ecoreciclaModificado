package com.tcc.ecoplus.ecorecicla.model.entity;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "REPRESENTANTECOLETORA")
public class RepresentanteColetora extends Usuario {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = true)
    private PessoaJuridica pessoaJuridica;

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }
}
