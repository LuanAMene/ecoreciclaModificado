package com.tcc.ecoplus.ecorecicla.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "residuo_destinadora")
@Data
public class Residuo_destinadora {

    private long id_residuo;
    private long cnpj_destinadora;

    @Transient
    @JsonIgnore
    private String mensagemError = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarResiduo_destinadora() {
        return isValid;
    }

    public long getId_residuo() {
        return id_residuo;
    }

    public void setId_residuo(int id_residuo) {
        this.id_residuo = id_residuo;
    }

    public long getCnpj_destinadora() {
        return cnpj_destinadora;
    }

    public void setCnpj_destinadora(int cnpj_destinadora) {
        this.cnpj_destinadora = cnpj_destinadora;
    }
}
