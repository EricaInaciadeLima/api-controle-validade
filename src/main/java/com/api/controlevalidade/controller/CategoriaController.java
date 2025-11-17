package com.api.controlevalidade.controller;

import com.api.controlevalidade.model.CategoriaModel;
import com.api.controlevalidade.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/cadastro")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<String> criarCategoria(@Valid @RequestBody CategoriaModel categoria) {
        categoriaService.salvarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria criada com sucesso!");
    }

    @GetMapping
    @PreAuthorize("hasRole('USUARIO') or hasRole('ADMINISTRADOR')")
    public ResponseEntity<List<CategoriaModel>> listarCategorias() {
        List<CategoriaModel> categorias = categoriaService.buscarTodos();
        return ResponseEntity.ok(categorias);
    }


}
