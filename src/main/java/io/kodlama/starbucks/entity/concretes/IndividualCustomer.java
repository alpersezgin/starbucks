package io.kodlama.starbucks.entity.concretes;

import io.kodlama.starbucks.entity.abstracts.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="individual_customer")
public class IndividualCustomer extends Customer {
    @Column(unique = true)
    private String nationalIdentity;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDate;
}
