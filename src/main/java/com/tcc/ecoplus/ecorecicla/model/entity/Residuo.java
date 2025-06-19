package com.tcc.ecoplus.ecorecicla.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
@Table(name = "Residuo")
public class Residuo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String classe;
    @Column(nullable = false, length = 50)
    private String tipo;
    @Column(nullable = true, length = 1000)
    private String descricao;
    private boolean codstatus;

    @OneToMany(mappedBy = "residuo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Residuo_Destinadora> residuoDestinadoras = new ArrayList<>();

    @Transient
    @JsonIgnore
    private String mensagemError = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;
    private String mensagemErro = "";

    public boolean validarResiduo() {
        return isValid;
    }


}
