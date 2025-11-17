package com.api.controlevalidade.repository;

import com.api.controlevalidade.model.PerfilModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilModel, Long> {
    Optional<PerfilModel> findByNomePerfil(String nomePerfil);
    boolean existsByNomePerfil(String nomePerfil);
}
