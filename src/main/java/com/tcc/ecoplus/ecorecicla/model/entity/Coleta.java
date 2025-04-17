package com.tcc.ecoplus.ecorecicla.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

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
    private LocalDateTime data;
    private boolean codstatus;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoaJuridica_id", referencedColumnName = "id", nullable = false)
    private PessoaJuridica pessoaJuridica;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "destinadora_id", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Destinadora destinadora;

    @Transient
    @JsonIgnore
    private String mensagemError = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;
    private String mensagemErro = "";

    public boolean validarColeta() {
        return isValid;
    }


}
