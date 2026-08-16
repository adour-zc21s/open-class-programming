package com.adour.openclassprog.repository;

import com.adour.openclassprog.model.Monitor;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/08/2026 - 17:47
 */
@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
