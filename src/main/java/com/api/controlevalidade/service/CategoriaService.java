package com.api.controlevalidade.service;

import com.api.controlevalidade.model.CategoriaModel;
import com.api.controlevalidade.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class CategoriaService {
    private static final Logger logger = LoggerFactory.getLogger(CategoriaService.class);

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaModel salvarCategoria(@Valid CategoriaModel categoria) {
        logger.debug("Salvando categoria: {}", categoria);
        return categoriaRepository.save(categoria);
    }

    public List<CategoriaModel> buscarTodos() {
        return categoriaRepository.findAll();
    }
}
