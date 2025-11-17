package com.api.controlevalidade.exception.custom;

public class CredenciaisInvalidasException extends RuntimeException {
    public CredenciaisInvalidasException(String mensagem) {
        super(mensagem);
    }
}