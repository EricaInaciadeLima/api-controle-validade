package com.api.controlevalidade.service;

import com.api.controlevalidade.model.EmpresaModel;
import com.api.controlevalidade.repository.EmpresaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaModel save(@Valid EmpresaModel empresa) {
        return empresaRepository.save(empresa);
    }
}