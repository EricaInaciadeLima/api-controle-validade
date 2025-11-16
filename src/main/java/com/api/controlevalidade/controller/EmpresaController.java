package com.api.controlevalidade.controller;

import com.api.controlevalidade.service.EmpresaService;
import com.api.controlevalidade.model.EmpresaModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<EmpresaModel> criar(@Valid @RequestBody EmpresaModel empresa) {
        EmpresaModel criada = empresaService.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }


}
