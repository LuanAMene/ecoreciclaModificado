package com.tcc.ecoplus.ecorecicla.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "coleta")
@Data
public class Coleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private String descricao;
    private int qt;
    private LocalDate data;
    private int cnpj_pj;
    private int cnpj_coletora;

    @Transient
    @JsonIgnore
    private String mensagemError = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarColeta() {
        return isValid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getCnpj_pj() {
        return cnpj_pj;
    }

    public void setCnpj_pj(int cnpj_pj) {
        this.cnpj_pj = cnpj_pj;
    }

    public int getCnpj_coletora() {
        return cnpj_coletora;
    }

    public void setCnpj_coletora(int cnpj_coletora) {
        this.cnpj_coletora = cnpj_coletora;
    }
}
