package com.api.controlevalidade.controller;

import com.api.controlevalidade.model.EmpresaModel;
import com.api.controlevalidade.model.ProdutoModel;
import com.api.controlevalidade.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produto")
@PreAuthorize("hasRole('USUARIO') or hasRole('ADMINISTRADOR')")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/cadastro")
    @PreAuthorize("hasRole('USUARIO') or hasRole('ADMINISTRADOR')")
    public ResponseEntity<String> criar(@Valid @RequestBody ProdutoModel produto) {
        produtoService.salvarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado com sucesso!");
    }

    @GetMapping
    @PreAuthorize("hasRole('USUARIO') or hasRole('ADMINISTRADOR')")
    public ResponseEntity<List<ProdutoModel>> listarProdutos() {
        List<ProdutoModel> produto = produtoService.buscarTodos();
        return ResponseEntity.ok(produto);
    }
}
