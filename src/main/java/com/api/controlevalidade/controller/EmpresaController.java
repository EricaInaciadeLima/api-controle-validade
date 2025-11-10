package com.api.controlevalidade.controller;

import com.api.controlevalidade.service.EmpresaService;
import com.api.controlevalidade.model.EmpresaModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }


   @PostMapping
   public ResponseEntity<EmpresaModel> criarEmpresa(@Valid @RequestBody EmpresaModel empresa) {
       EmpresaModel criada = empresaService.save(empresa);
       return ResponseEntity.status(HttpStatus.CREATED).body(criada);
   }

}
