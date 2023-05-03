package io.kodlama.starbucks.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCorporateCustomerResponse {
    private int id;
    private String socialSecurityRegistrationNumber;
    private String email;
    private String password;
    private String corporateName;
    private String contactPhone;
}
