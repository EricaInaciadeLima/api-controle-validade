package com.api.controlevalidade.model.tiposEnuns;

public enum TipoPerfil {
    ADMINISTRADOR("Administrador do sistema"),
    USUARIO("Usuário comum");

    private final String tipo;

    TipoPerfil(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}