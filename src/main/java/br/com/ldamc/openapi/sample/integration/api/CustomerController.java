package br.com.ldamc.openapi.sample.integration.api;

import br.com.ldamc.openapi.sample.cross.mapper.CustomerMapper;
import br.com.ldamc.openapi.sample.domain.customer.model.Customer;
import br.com.ldamc.openapi.sample.domain.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CustomersApi;
import org.openapitools.model.RegisterCustomerRequest;
import org.openapitools.model.RegisterCustomerResponse;
import org.openapitools.model.SearchCustomerResponse;
import org.openapitools.model.UpdateCustomerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomersApi {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Override
    public ResponseEntity<Void> customersCustomerIdDelete(Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<SearchCustomerResponse> customersCustomerIdGet(Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        SearchCustomerResponse response = customerMapper.toResponse(customer);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<Void> customersCustomerIdPut(Long customerId, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerMapper.toDomain(updateCustomerRequest);
        customerService.updateCustomer(customerId, customer);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<List<SearchCustomerResponse>> customersGet() {
         List<Customer> allCustomers = customerService.getAllCustomers();
        List<SearchCustomerResponse> response = customerMapper.toResponseList(allCustomers);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<RegisterCustomerResponse> customersPost(RegisterCustomerRequest registerCustomerRequest) {
        Customer customer = customerMapper.toDomain(registerCustomerRequest);
        Long id = customerService.createCustomer(customer).getId();
        RegisterCustomerResponse response = customerMapper.toResponse(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
