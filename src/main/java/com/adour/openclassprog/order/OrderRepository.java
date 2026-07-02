package com.adour.openclassprog.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 20:00
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
