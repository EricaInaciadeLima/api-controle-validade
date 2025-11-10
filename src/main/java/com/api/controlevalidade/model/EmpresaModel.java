package com.api.controlevalidade.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_Empresa", schema = "ControleValidade")
public class EmpresaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome fantasia é obrigatório!")
    @Size(max = 100, message = "Máximo 100 caracteres.")
    @Column(name = "nome_fantasia", nullable = false, length = 100)
    private String nomeFantasia;

    @NotBlank(message = "Razão social é obrigatória!")
    @Size(max = 100)
    @Column(name = "razao_social", nullable = false, length = 100)
    private String razaoSocial;

    @NotBlank(message = "Nome do dono é obrigatório!")
    @Size(max = 100)
    @Column(name = "nome_dono", nullable = false, length = 100)
    private String nomeDono;

    @NotBlank(message = "CNPJ é obrigatório!")
    @Size(max = 20)
    @Column(nullable = false, unique = true, length = 20)
    private String cnpj;

    public EmpresaModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
