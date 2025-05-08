package com.tcc.ecoplus.ecorecicla.exceptions;


public class NotFound extends RuntimeException {

    public NotFound(String message) {
        // super: acessando o construtor da classe pai
        super(message);
    }
}
