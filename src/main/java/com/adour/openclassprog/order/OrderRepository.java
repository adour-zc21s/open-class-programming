package com.adour.openclassprog.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 20:00
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT COALESCE(SUM(o.totalAmount), 0) FROM Order o WHERE UPPER(o.status) = UPPER(:status)")
    BigDecimal sumTotalAmountByStatus(@Param("status") String status);
}
