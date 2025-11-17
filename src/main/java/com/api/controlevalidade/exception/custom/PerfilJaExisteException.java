package com.api.controlevalidade.exception.custom;

public class PerfilJaExisteException extends RuntimeException {
    public PerfilJaExisteException(String message) {
        super(message);
    }
}