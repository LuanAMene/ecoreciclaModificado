package com.tcc.ecoplus.ecorecicla.exceptions;


public class BadRequest extends RuntimeException {

    public BadRequest(String message) {
        // super: acessando o construtor da classe pai
        super(message);
    }
}
