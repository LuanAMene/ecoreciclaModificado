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
    @Column(nullable = false, length = 45)
    private String status;
    @Column(nullable = false, length = 45)
    private String descricao;
    @Column(nullable = false, length = 10)
    private String qt;
    @Column(nullable = false, length = 45)
    private LocalDateTime data;
    @Column(nullable = false, length = 45)
    private boolean codstatus;



    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "geradora_id", referencedColumnName = "id", nullable = false)
    private Geradora geradora;

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
