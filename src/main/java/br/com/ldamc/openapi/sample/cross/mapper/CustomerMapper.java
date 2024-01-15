package br.com.ldamc.openapi.sample.cross.mapper;

import br.com.ldamc.openapi.sample.domain.customer.model.Customer;
import br.com.ldamc.openapi.sample.integration.repository.model.CustomerEntity;
import org.mapstruct.Mapper;
import org.openapitools.model.RegisterCustomerRequest;
import org.openapitools.model.RegisterCustomerResponse;
import org.openapitools.model.SearchCustomerResponse;
import org.openapitools.model.UpdateCustomerRequest;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity toEntity(Customer customer);
    Customer toDomain(CustomerEntity customerEntity);
    Customer toDomain(RegisterCustomerRequest customerEntity);
    Customer toDomain(UpdateCustomerRequest customerEntity);
    List<Customer> toDomainList(List<CustomerEntity> customer);
    List<SearchCustomerResponse> toResponseList(List<Customer> customer);
    RegisterCustomerResponse toResponse(Long id);
    SearchCustomerResponse toResponse(Customer customer);

}
