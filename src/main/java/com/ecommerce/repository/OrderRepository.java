package com.ecommerce.repository;

import com.ecommerce.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByCustomerId(Long customerId, Pageable pageable);

    @Query("SELECT o FROM Order o WHERE o.customer.id = :customerId ORDER BY o.orderDate DESC")
    List<Order> findRecentOrdersByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findByStatus(@Param("status") String status);

    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate")
    List<Order> findByOrderDateBetween(@Param("startDate") LocalDateTime startDate, 
                                        @Param("endDate") LocalDateTime endDate);

    @Query("SELECT o FROM Order o WHERE o.customer.id = :customerId AND o.status = :status")
    List<Order> findByCustomerIdAndStatus(@Param("customerId") Long customerId, 
                                           @Param("status") String status);

    @Query("SELECT o FROM Order o WHERE o.status = 'PENDING' ORDER BY o.orderDate ASC")
    List<Order> findPendingOrders();

    @Query("SELECT o FROM Order o WHERE o.status = 'COMPLETED' AND o.orderDate >= :since")
    List<Order> findCompletedOrdersSince(@Param("since") LocalDateTime since);

    @Query("SELECT COUNT(o) FROM Order o WHERE o.customer.id = :customerId")
    Long countOrdersByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.customer.id = :customerId")
    java.math.BigDecimal sumTotalAmountByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT o FROM Order o JOIN o.products p WHERE p.id = :productId")
    List<Order> findByProductId(@Param("productId") Long productId);

    @Query("SELECT o.status, COUNT(o) FROM Order o GROUP BY o.status")
    List<Object[]> countOrdersByStatus();

    Optional<Order> findTopByCustomerIdOrderByOrderDateDesc(Long customerId);

    @Query("SELECT o FROM Order o WHERE o.customer.email = :email")
    List<Order> findByCustomerEmail(@Param("email") String email);
}