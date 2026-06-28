package com.adour.openclassprog.repository;

import com.adour.openclassprog.model.Wilayah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/06/2026 - 9:49
 */
@Repository
public interface WilayahRepository extends JpaRepository<Wilayah, Long> {
}
