package br.com.ldamc.openapi.sample.config;

import feign.okhttp.OkHttpClient;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class FeignConfig {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

}
