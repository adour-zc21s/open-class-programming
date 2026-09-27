package com.adour.openclassprog.pocket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
 * @author {Riset Inovasi Ekosistem Komputasi}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/09/2026 - 18:26
 */
@Repository
public interface PocketRepository extends JpaRepository<Pocket, Long> {
}
