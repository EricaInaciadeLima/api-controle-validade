package com.api.controlevalidade.service;

import com.api.controlevalidade.model.CategoriaModel;
import com.api.controlevalidade.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaModel save(@Valid CategoriaModel categoria) {
        return  categoriaRepository.save(categoria);
    }
}
