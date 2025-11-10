package com.api.controlevalidade.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_Categoria", schema = "ControleValidade")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Nome da categoria é obrigatório!")
    @Size(max = 50, message = "Máximo 50 caracteres.")
    @Column(name = "nome", nullable = false, length = 50)
    private String nomeCategoria;

    @Size(max = 255, message = "Máximo 255 caracteres")
    @Column( length = 255)
    private String descricao;


    public CategoriaModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
