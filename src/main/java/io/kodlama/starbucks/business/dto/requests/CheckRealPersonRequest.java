package io.kodlama.starbucks.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckRealPersonRequest {
    private String nationalIdentity;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDate;
}

