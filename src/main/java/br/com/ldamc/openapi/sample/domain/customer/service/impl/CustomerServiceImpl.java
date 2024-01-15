package br.com.ldamc.openapi.sample.domain.customer.service.impl;

import br.com.ldamc.openapi.sample.cross.mapper.CustomerMapper;
import br.com.ldamc.openapi.sample.domain.customer.model.Customer;
import br.com.ldamc.openapi.sample.domain.customer.service.CustomerService;
import br.com.ldamc.openapi.sample.integration.client.CustomerValidationClient;
import br.com.ldamc.openapi.sample.integration.repository.CustomerRepository;
import br.com.ldamc.openapi.sample.integration.repository.model.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerValidationClient customerValidationClient;

    // Operação CREATE
    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = customerMapper.toEntity(customer);
        Long id = customerRepository.save(customerEntity).getId();
        customer.setId(id);
        return customer;
    }

    // Operação READ
    public List<Customer> getAllCustomers() {
        return customerMapper.toDomainList(customerRepository.findAll());
    }

    public Customer getCustomerById(Long customerId) {
        Optional<CustomerEntity> customerOptional = customerRepository.findById(customerId);
        return customerMapper.toDomain(customerOptional.orElseThrow(RuntimeException::new));
    }

    // Operação UPDATE
    public Customer updateCustomer(Long customerId, Customer newCustomerData) {
         CustomerEntity customerEntity = customerRepository.findById(customerId).map(customer -> {
            customer.setName(newCustomerData.getName());
            customer.setLastName(newCustomerData.getLastName());
            customer.setEmail(newCustomerData.getEmail());
            customer.setAge(newCustomerData.getAge());
            return customerRepository.save(customer);
        }).orElseThrow(RuntimeException::new);
        return customerMapper.toDomain(customerEntity);
    }

    // Operação DELETE
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
