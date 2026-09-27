package com.adour.openclassprog.pocket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author {Riset Inovasi Ekosistem Komputasi}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/09/2026 - 18:28
 */
@Repository
public interface PocketItemRepository extends JpaRepository<PocketItem, Long> {
    List<PocketItem> findByPocketId(Long pocketId);
    // Query untuk mengambil item berdasarkan bulan dan tahun
    @Query("SELECT i FROM PocketItem i WHERE i.pocket.id = :pocketId " +
            "AND FUNCTION('MONTH', i.transactionDate) = :month " +
            "AND FUNCTION('YEAR', i.transactionDate) = :year " +
            "ORDER BY i.transactionDate DESC")
    List<PocketItem> findByPocketIdAndMonthAndYear(
            @Param("pocketId") Long pocketId,
            @Param("month") int month,
            @Param("year") int year
    );
}
