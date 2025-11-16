package com.api.controlevalidade.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_Produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Nome é obrigatório!")
    @Size(max = 100)
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Marca é obrigatório!")
    @Size(max = 50)
    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaModel categoria;

    @NotNull
    @Column(name = "data_fabricacao", nullable = false)
    private LocalDate dataFabricacao;

    @NotNull
    @Column(name = "data_validade", nullable = false)
    private LocalDate dataValidade;

    @NotBlank(message = "Lote é obrigatório!")
    @Size(max = 50)
    @Column(name = "lote", nullable = false, length = 50)
    private String lote;

    @NotNull
    @Column(name = "data_alerta", nullable = false)
    private LocalDate dataAlerta;

    @NotNull
    @ManyToOne( optional = false)
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaModel empresa;

    public ProdutoModel() {}

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public CategoriaModel getCategoria() { return categoria; }
    public void setCategoria(CategoriaModel categoria) { this.categoria = categoria; }

    public LocalDate getDataFabricacao() { return dataFabricacao; }
    public void setDataFabricacao(LocalDate dataFabricacao) { this.dataFabricacao = dataFabricacao; }

    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }

    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }

    public LocalDate getDataAlerta() { return dataAlerta; }
    public void setDataAlerta(LocalDate dataAlerta) { this.dataAlerta = dataAlerta; }

    public EmpresaModel getEmpresa() { return empresa; }
    public void setEmpresa(EmpresaModel empresa) { this.empresa = empresa; }
}