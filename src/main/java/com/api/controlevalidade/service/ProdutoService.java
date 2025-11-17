package com.api.controlevalidade.service;

import com.api.controlevalidade.model.ProdutoModel;
import com.api.controlevalidade.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private CategoriaService categoriaService;

    public ProdutoModel salvarProduto(@Valid ProdutoModel produto) {
        Long empresaId = produto.getEmpresa().getId();
        Long categoriaId = produto.getCategoria().getId();

        // Valida se empresa e categoria existem
        var empresa = empresaService.buscarPorId(empresaId);
        var categoria = categoriaService.buscarPorId(categoriaId);

        // Reatribui entidades completas
        produto.setEmpresa(empresa);
        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }

    public List<ProdutoModel> buscarTodos() {
        return produtoRepository.findAll();
    }
}