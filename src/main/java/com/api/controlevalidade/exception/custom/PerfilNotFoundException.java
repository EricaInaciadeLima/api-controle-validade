package com.api.controlevalidade.exception.custom;

public class PerfilNotFoundException extends RuntimeException {
    public PerfilNotFoundException(String message) {
        super(message);
    }
}