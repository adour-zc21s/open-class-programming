package com.adour.openclassprog.repository;

import com.adour.openclassprog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 10/06/2026 - 16:52
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
