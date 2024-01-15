package br.com.ldamc.openapi.sample.domain.customer.service;

import br.com.ldamc.openapi.sample.domain.customer.model.Customer;
import br.com.ldamc.openapi.sample.integration.repository.model.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    // Operação READ
    List<Customer> getAllCustomers();

    Customer getCustomerById(Long customerId);

    // Operação UPDATE
    Customer updateCustomer(Long customerId, Customer newCustomerData);

    // Operação DELETE
    void deleteCustomer(Long customerId);

}
