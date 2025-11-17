package com.api.controlevalidade.exception.custom;

public class CnpjDuplicadoException extends RuntimeException {
    public CnpjDuplicadoException(String message) {
        super(message);
    }
}