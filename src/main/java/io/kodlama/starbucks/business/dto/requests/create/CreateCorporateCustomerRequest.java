package io.kodlama.starbucks.business.dto.requests.create;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCorporateCustomerRequest {
    @NotNull
    @Length(min = 6, message = "Too short social security registration number")
    private String socialSecurityRegistrationNumber;

    @NotNull
    @Email(message = "Not valid email")
    private String email;

    @NotNull
    @Length(min = 6, message = "Too short password")
    @Length(max = 30, message = "Too long password")
    private String password;

    @NotBlank
    @Size(min = 2, max = 50, message = "Corporate name must be between 2 and 50 characters")
    private String corporateName;

    @NotNull
    @Size(min = 7, max = 23, message = "Phone number must be between 10 and 20 characters")
    private String contactPhone;
}
