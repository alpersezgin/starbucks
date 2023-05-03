package io.kodlama.starbucks.entity.concretes;

import io.kodlama.starbucks.entity.abstracts.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="corporate_customer")
public class CorporateCustomer extends Customer {
    @Column(unique = true, name = "ssrn")
    private String socialSecurityRegistrationNumber;
    @Column(unique = true, name = "name")
    private String corporateName;
    private String contactPhone;
}
