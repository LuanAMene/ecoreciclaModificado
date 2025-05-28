package com.tcc.ecoplus.ecorecicla.auth;

import com.tcc.ecoplus.ecorecicla.model.entity.Role;
import lombok.Data;


@Data
public class RegisterRequest {

    private String nome;
    private String email;
    private String password;
    private Role role;

    public RegisterRequest() {


    }

    public RegisterRequest(String nome, String email, String password, Role role) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
