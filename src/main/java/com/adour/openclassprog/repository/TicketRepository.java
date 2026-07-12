package com.adour.openclassprog.repository;

import com.adour.openclassprog.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 09/07/2026 - 17:36
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t.noTiket FROM Ticket t WHERE t.noTiket LIKE CONCAT(:prefix, '%') ORDER BY t.noTiket DESC LIMIT 1")
    Optional<String> findLatestTicketNoByPrefix(@Param("prefix") String prefix);
}
