package io.kodlama.starbucks.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateIndividualCustomerResponse {
    private int id;
    private String email;
    private String password;
    private String nationalIdentity;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDate;
}
