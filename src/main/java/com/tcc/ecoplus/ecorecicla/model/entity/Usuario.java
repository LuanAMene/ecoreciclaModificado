package com.tcc.ecoplus.ecorecicla.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.tcc.ecoplus.ecorecicla.model.token.Token;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "role")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "ADMIN"),
        @JsonSubTypes.Type(value = RepresentanteColetora.class, name = "REPRESENTANTECOLETORA"),
        @JsonSubTypes.Type(value = RepresentanteDestinadora.class, name = "REPRESENTANTEDESTINADORA"),
})
@EnableJpaAuditing
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = true, length = 45)
    private String nome;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 250)
    private String password;
    @Column(nullable = true)
    private byte imagem;
    private boolean codStatus;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private List<Destinadora> destinadoras = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Geradora> geradoras = new ArrayList<>();


    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Token> tokens;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Role role;


    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public Usuario(byte imagem) {
        this.imagem = imagem;
    }

    public Usuario() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isValid() {
        return true;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void setEmail(String email) {
        this.email = email;


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCodStatus() {
        return true;
    }

    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }



    public String getMensagemErro() {
        return mensagemErro;
    }

    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    public boolean validarUsuario() {
        return isValid;
    }

    public void setCodstatus(boolean b) {
    }

    public byte getImagem() {
        return imagem;
    }

    public void setImagem(byte imagem) {
        this.imagem = imagem;
    }
}
