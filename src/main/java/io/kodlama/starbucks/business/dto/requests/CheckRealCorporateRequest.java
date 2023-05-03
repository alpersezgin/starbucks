package io.kodlama.starbucks.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckRealCorporateRequest {
    private String socialSecurityRegistrationNumber;
    private String corporateName;
}

