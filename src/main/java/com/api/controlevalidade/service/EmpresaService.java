package com.api.controlevalidade.service;

import com.api.controlevalidade.model.EmpresaModel;
import com.api.controlevalidade.repository.EmpresaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaModel save(@Valid EmpresaModel empresa) {
        return empresaRepository.save(empresa);
    }

    public List<EmpresaModel> buscarTodos() {
        return empresaRepository.findAll();
    }

    public EmpresaModel buscarPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada com ID: " + id));
    }
}