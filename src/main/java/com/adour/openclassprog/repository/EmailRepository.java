package com.adour.openclassprog.repository;

import com.adour.openclassprog.model.Device;
import com.adour.openclassprog.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/07/2026 - 9:50
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByEmailContainingIgnoreCase(String emailAddress);
}
