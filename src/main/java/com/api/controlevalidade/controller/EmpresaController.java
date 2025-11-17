package com.api.controlevalidade.controller;

import com.api.controlevalidade.service.EmpresaService;
import com.api.controlevalidade.model.EmpresaModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping("/cadastro")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<String> criar(@Valid @RequestBody EmpresaModel empresa) {
        empresaService.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body("Empresa criada com sucesso!");
    }

    @GetMapping
    @PreAuthorize("hasRole('USUARIO') or hasRole('ADMINISTRADOR')")
    public ResponseEntity<List<EmpresaModel>> listarEmpresas() {
        List<EmpresaModel> empresa = empresaService.buscarTodos();
        return ResponseEntity.ok(empresa);
    }
}
