package com.tcc.ecoplus.ecorecicla.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Geradora")
@Data
public class Geradora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 45)
    private long cnpj;
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false, length = 20)
    private String ramo;
    @Column(nullable = false, length = 20)
    private String num;
    @Column(nullable = false, length = 10)
    private String cep;
    @Column(nullable = true, length = 45)
    private String cidade;
    @Column(nullable = true, length = 100)
    private String logradouro;
    @Column(nullable = true, length = 45)
    private String bairro;
    @Column(nullable = true, length = 2)
    private String uf;
    @Column(nullable = false, length = 15)
    private String email;
    @Column(nullable = false, length = 100)
    private String telefone;
    @Column(nullable = false, length = 13)
    private String senha;
    private boolean codstatus;

    @OneToMany(mappedBy = "Geradora",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Coleta> coletas = new ArrayList<Coleta>();

    @OneToMany(mappedBy = "residuo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RepresentanteColetora> representanteColetoras = new ArrayList<>();

    @Transient
    @JsonIgnore
    private String mensagemError = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarPessoaJuridica() {
        return isValid;
    }

}
