package com.tcc.ecoplus.ecorecicla.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "Destinadora")
@Data
public class Destinadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String cnpj;
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
    @Column(nullable = false, length = 100)
    private String telefone;
    private boolean codStatus;

    @OneToMany(mappedBy = "destinadora",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private List<Coleta> coletas = new ArrayList<>();

    @OneToMany(mappedBy = "destinadora", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Residuo_Destinadora> residuo_destinadoras = new ArrayList<>();

    @OneToMany(mappedBy = "destinadora", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RepresentanteDestinadora> representanteDestinadora = new ArrayList<>();

  //  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    //@JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    //private Usuario usuario;

    @Transient
    @JsonIgnore
    private String mensagemError = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;
    private String mensagemErro = "";

    public boolean validarDestinadora() {
        return isValid;
    }
}
