package com.api.controlevalidade.repository;

import com.api.controlevalidade.model.PerfilModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilModel, Long> {
    PerfilModel findByNomePerfil(String nomePerfil);
}
