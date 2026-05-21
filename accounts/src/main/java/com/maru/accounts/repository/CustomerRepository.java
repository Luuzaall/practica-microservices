package com.maru.accounts.repository;

import com.maru.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //El segundo es el tipo del PK.


    Optional<Customer> findByMobileNumber(String mobileNumber);



}
