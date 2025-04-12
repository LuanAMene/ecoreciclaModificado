package com.tcc.ecoplus.ecorecicla.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Table(name = "Usuario")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "role")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "ADMIN"),
        @JsonSubTypes.Type(value = RepresentanteColetora.class, name = "REPRESENTANTECOLETORA"),
        @JsonSubTypes.Type(value = RepresentanteDestinadora.class, name = "REPRESENTANTEDESTINADORA"),
})
@EnableJpaAuditing
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 250)
    private String password;
    private boolean codstatus;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Role role;


    @Transient
    @JsonIgnore
    private boolean isValid = true;

    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    public boolean validarUsuario() {
        return isValid;
    }

}
