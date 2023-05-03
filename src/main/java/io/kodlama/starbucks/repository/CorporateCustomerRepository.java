package io.kodlama.starbucks.repository;

import io.kodlama.starbucks.entity.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer> {
    boolean existsBySocialSecurityRegistrationNumber(String ssrn);
    boolean existsByEmail(String email);
    boolean existsByCorporateName(String corporateName);
    boolean existsByEmailOrCorporateName(String email, String corporateName);
}
