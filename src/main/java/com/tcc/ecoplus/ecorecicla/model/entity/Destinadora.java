package com.tcc.ecoplus.ecorecicla.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "destinadora")
@Data
public class Destinadora {

    @Id
    private long cnpj;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 45)
    private String num;
    @Column(nullable = false, length = 10)
    private String cep;
    @Column(nullable = false, length = 6)
    private String email;
    @Column(nullable = false, length = 100)
    private String telefone;
    @Column(nullable = true, length = 13)
    private String senha;
    @Column(nullable = false, length = 20)

    @Transient
    @JsonIgnore
    private String mensagemError = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarDestinadora() {
        return isValid;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
