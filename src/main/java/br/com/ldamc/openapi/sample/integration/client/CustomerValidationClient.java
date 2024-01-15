package br.com.ldamc.openapi.sample.integration.client;

import br.com.ldamc.openapi.sample.config.FeignConfig;
import br.com.ldamc.openapi.sample.integration.client.model.CustomerValidatorRequest;
import br.com.ldamc.openapi.sample.integration.client.model.CustomerValidatorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "customerValidation",
        url = "https://jsonplaceholder.typicode.com/",
        configuration = FeignConfig.class
)
public interface CustomerValidationClient {

    @RequestMapping(method = RequestMethod.POST, value = "/posts")
    CustomerValidatorResponse validateCustomer(@RequestBody CustomerValidatorRequest request);

}
