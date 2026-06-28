package com.adour.openclassprog.repository;

import com.adour.openclassprog.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 11:12
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
