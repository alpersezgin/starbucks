package io.kodlama.starbucks.business.dto.requests.update;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateIndividualCustomerRequest {
    @NotNull
    @Email(message = "Not valid email")
    private String email;

    @NotNull
    @Length(min = 6, message = "Too short password")
    @Length(max = 30, message = "Too long password")
    private String password;

    //@Size(min = 11, max = 11, message = "National identity number must be 11 characters")
    private String nationalIdentity;

    @NotBlank
    @Length(max = 50, message = "Too long first name")
    private String firstName;

    @NotBlank
    @Length(max = 50, message = "Too long last name")
    private String lastName;

    @NotNull
    @Past
    private LocalDateTime birthDate;
}
