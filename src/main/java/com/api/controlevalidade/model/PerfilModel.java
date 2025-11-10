package com.api.controlevalidade.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_Perfil", schema = "ControleValidade")
public class PerfilModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do perfil é obrigatório!")
    @Size(max = 50)
    @Column(name = "nome_perfil", nullable = false, length = 50)
    private String nomePerfil;

    @NotBlank(message = "Senha é obrigatória!")
    @Size(max = 8)
    @Column(nullable = false, length = 8)
    private String senha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaModel empresa;

    public PerfilModel() {}

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }
}