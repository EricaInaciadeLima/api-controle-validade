package com.api.controlevalidade.repository;

import com.api.controlevalidade.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer> {
}
