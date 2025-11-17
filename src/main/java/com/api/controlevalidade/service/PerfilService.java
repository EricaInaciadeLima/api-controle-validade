package com.api.controlevalidade.service;

import com.api.controlevalidade.model.PerfilModel;
import com.api.controlevalidade.repository.PerfilRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PerfilService implements UserDetailsService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public PerfilModel save(@Valid PerfilModel perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public UserDetails loadUserByUsername(String nomePerfil) throws UsernameNotFoundException {
        return perfilRepository.findByNomePerfil(nomePerfil)
                .orElseThrow(() -> new UsernameNotFoundException("Perfil não encontrado: " + nomePerfil));
    }

    public boolean existsByNomePerfil(String nomePerfil) {
        return perfilRepository.existsByNomePerfil(nomePerfil);
    }

}
