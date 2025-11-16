package com.api.controlevalidade.controller;

import com.api.controlevalidade.model.PerfilModel;
import com.api.controlevalidade.model.ProdutoModel;
import com.api.controlevalidade.service.PerfilService;
import com.api.controlevalidade.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/perfil")
public class PerfilController {


    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }


    @PostMapping
    public ResponseEntity<PerfilModel> criar(@Valid @RequestBody PerfilModel perfil) {
        PerfilModel criado = perfilService.save(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
