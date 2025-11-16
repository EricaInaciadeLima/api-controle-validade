package com.api.controlevalidade.service;

import com.api.controlevalidade.model.ProdutoModel;
import com.api.controlevalidade.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel salvarProduto(@Valid ProdutoModel produto) {
        return produtoRepository.save(produto);
    }
}
