package br.com.ldamc.openapi.sample.cross.mapper;

import br.com.ldamc.openapi.sample.domain.customer.model.Customer;
import br.com.ldamc.openapi.sample.integration.repository.model.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity toEntity(Customer customer);
    Customer toDomain(CustomerEntity customerEntity);
    List<Customer> toDomainList(List<CustomerEntity> customer);

}
