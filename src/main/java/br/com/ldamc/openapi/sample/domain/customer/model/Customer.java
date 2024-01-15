package br.com.ldamc.openapi.sample.domain.customer.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String email;
}
