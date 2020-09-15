package com.orderProduct.orderproduct.repository;

import com.orderProduct.orderproduct.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT u FROM Customer u WHERE u.email = ?1 and u.password = ?2")
    Customer findUserByEmailAndPassword(String email, String password);
}
