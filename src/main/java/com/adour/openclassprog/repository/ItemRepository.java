package com.adour.openclassprog.repository;

import com.adour.openclassprog.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 13:49
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
