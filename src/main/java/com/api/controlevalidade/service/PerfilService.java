package com.api.controlevalidade.service;

import com.api.controlevalidade.model.PerfilModel;
import com.api.controlevalidade.repository.PerfilRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    private final  PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public PerfilModel save(@Valid PerfilModel perfil) {
        return perfilRepository.save(perfil);
    }
}
