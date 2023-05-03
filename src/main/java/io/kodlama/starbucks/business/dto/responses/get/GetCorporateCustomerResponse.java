package io.kodlama.starbucks.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCorporateCustomerResponse {
    private int id;
    private String socialSecurityRegistrationNumber;
    private String email;
    private String password;
    private String corporateName;
    private String contactPhone;
}
