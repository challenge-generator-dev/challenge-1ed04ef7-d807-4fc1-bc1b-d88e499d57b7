package com.ecommerce.repository;

import com.ecommerce.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Customer> searchByName(@Param("name") String name);

    @Query("SELECT c FROM Customer c WHERE c.city = :city")
    List<Customer> findByCity(@Param("city") String city);

    @Query("SELECT c FROM Customer c WHERE c.country = :country")
    List<Customer> findByCountry(@Param("country") String country);

    @Query("SELECT c FROM Customer c WHERE c.city = :city AND c.country = :country")
    List<Customer> findByCityAndCountry(@Param("city") String city, 
                                         @Param("country") String country);

    @Query("SELECT c FROM Customer c WHERE c.phone IS NOT NULL AND c.phone <> ''")
    List<Customer> findCustomersWithPhone();

    @Query("SELECT c FROM Customer c JOIN c.orders o WHERE o.status = 'COMPLETED' GROUP BY c HAVING COUNT(o) >= :minOrders")
    List<Customer> findFrequentCustomers(@Param("minOrders") Long minOrders);

    @Query("SELECT c FROM Customer c JOIN c.orders o GROUP BY c ORDER BY SUM(o.totalAmount) DESC")
    List<Customer> findTopCustomersBySpent();

    @Query("SELECT c FROM Customer c WHERE c.email LIKE CONCAT('%', :domain)")
    List<Customer> findByEmailDomain(@Param("domain") String domain);

    @Query("SELECT c.country, COUNT(c) FROM Customer c GROUP BY c.country")
    List<Object[]> countCustomersByCountry();

    @Query("SELECT c.state, COUNT(c) FROM Customer c WHERE c.country = :country GROUP BY c.state")
    List<Object[]> countCustomersByStateInCountry(@Param("country") String country);

    Page<Customer> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);

    @Query("SELECT c FROM Customer c WHERE c.addressLine2 IS NOT NULL AND c.addressLine2 <> ''")
    List<Customer> findCustomersWithSecondaryAddress();

    Optional<Customer> findByEmailAndPassword(String email, String password);