package com.adour.openclassprog.repository;

import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 24/06/2026 - 17:30
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    List<BranchDTO> findByNameContainingIgnoreCase(String name);
}
