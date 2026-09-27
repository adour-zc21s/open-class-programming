package com.adour.openclassprog.pocket;

import java.math.BigDecimal;
import java.util.List;
/*
 * @author {Riset Inovasi Ekosistem Komputasi}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/09/2026 - 18:29
 */
public interface PocketService {
 // Pocket Operations
 Pocket createPocket(Pocket pocket);
 List<Pocket> getAllPockets();
 Pocket getPocketById(Long id);
 void deletePocket(Long id);
 BigDecimal getPocketBalance(Long id);

 // PocketItem Operations
 PocketItem addItemToPocket(Long pocketId, PocketItem item);
 List<PocketItem> getItemsByPocketId(Long pocketId);
 void deleteItem(Long itemId);
 MonthlyReportResponseDTO getMonthlyReport(Long pocketId, int month, int year);
}
