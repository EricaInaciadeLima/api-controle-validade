package com.api.controlevalidade.repository;

import com.api.controlevalidade.model.EmpresaModel;
import com.api.controlevalidade.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
