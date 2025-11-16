package com.api.controlevalidade.controller;

import com.api.controlevalidade.model.CategoriaModel;
import com.api.controlevalidade.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private static final Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<CategoriaModel> criarCategoria(@Valid @RequestBody CategoriaModel categoria) {
        logger.info("Recebendo categoria para cadastro: {}", categoria);
        CategoriaModel criada = categoriaService.salvarCategoria(categoria);
        logger.info("Categoria criada com ID: {}", criada.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> listarCategorias() {
        List<CategoriaModel> categorias = categoriaService.buscarTodos();
        return ResponseEntity.ok(categorias);
    }


}
