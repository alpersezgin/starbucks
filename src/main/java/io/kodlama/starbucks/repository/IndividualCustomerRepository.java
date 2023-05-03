package io.kodlama.starbucks.repository;

import io.kodlama.starbucks.entity.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {
    boolean existsByEmail(String email);
    boolean existsByNationalIdentity(String nationalIdentity);

}
