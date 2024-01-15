package br.com.ldamc.openapi.sample.integration.repository;

import br.com.ldamc.openapi.sample.integration.repository.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {}
