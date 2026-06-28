package com.adour.openclassprog.repository;

import com.adour.openclassprog.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 22:11
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
