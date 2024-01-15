package br.com.ldamc.openapi.sample.integration.api;

import org.openapitools.api.CustomersApi;
import org.springframework.http.ResponseEntity;

public class CustomerController implements CustomersApi {

  @Override
  public ResponseEntity<Void> customersCustomerIdDelete(Integer customerId) {
    return CustomersApi.super.customersCustomerIdDelete(customerId);
  }

  @Override
  public ResponseEntity<Void> customersCustomerIdGet(Integer customerId) {
    return CustomersApi.super.customersCustomerIdGet(customerId);
  }

  @Override
  public ResponseEntity<Void> customersCustomerIdPut(Integer customerId) {
    return CustomersApi.super.customersCustomerIdPut(customerId);
  }

  @Override
  public ResponseEntity<Void> customersGet() {
    return CustomersApi.super.customersGet();
  }

  @Override
  public ResponseEntity<Void> customersPost() {
    return CustomersApi.super.customersPost();
  }
}
