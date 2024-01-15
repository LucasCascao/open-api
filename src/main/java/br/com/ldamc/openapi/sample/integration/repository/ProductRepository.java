package br.com.ldamc.openapi.sample.integration.repository;

import br.com.ldamc.openapi.sample.integration.repository.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Long, ProductEntity> {}
