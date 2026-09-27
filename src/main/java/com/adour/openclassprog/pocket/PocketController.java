package com.adour.openclassprog.pocket;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
/*
 * @author {Riset Inovasi Ekosistem Komputasi}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/09/2026 - 18:30
 */
@RestController
@RequestMapping("/api/v1/pockets")
@CrossOrigin("*")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class PocketController {

    private final PocketService pocketService;

    public PocketController(PocketService pocketService) {
        this.pocketService = pocketService;
    }

    // --- Endpoint Pocket ---

    @PostMapping
    public ResponseEntity<Pocket> createPocket(@RequestBody Pocket pocket) {
        Pocket created = pocketService.createPocket(pocket);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pocket>> getAllPockets() {
        return ResponseEntity.ok(pocketService.getAllPockets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pocket> getPocketById(@PathVariable Long id) {
        return ResponseEntity.ok(pocketService.getPocketById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePocket(@PathVariable Long id) {
        pocketService.deletePocket(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> getPocketBalance(@PathVariable Long id) {
        return ResponseEntity.ok(pocketService.getPocketBalance(id));
    }

    // --- Endpoint Pocket Items (Gaji, Pemasukan Lain, Pengeluaran) ---

    @PostMapping("/{pocketId}/items")
    public ResponseEntity<PocketItem> addItem(
            @PathVariable Long pocketId,
            @RequestBody PocketItem item) {
        PocketItem createdItem = pocketService.addItemToPocket(pocketId, item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @GetMapping("/{pocketId}/items")
    public ResponseEntity<List<PocketItem>> getItemsByPocket(@PathVariable Long pocketId) {
        return ResponseEntity.ok(pocketService.getItemsByPocketId(pocketId));
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        pocketService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{pocketId}/monthly-report")
    public ResponseEntity<MonthlyReportResponseDTO> getMonthlyReport(
            @PathVariable Long pocketId,
            @RequestParam(value = "month", required = false) Integer month,
            @RequestParam(value = "year", required = false) Integer year) {

        // Set default ke bulan dan tahun saat ini jika param tidak diisi
        java.time.LocalDate now = java.time.LocalDate.now();
        int targetMonth = (month != null) ? month : now.getMonthValue();
        int targetYear = (year != null) ? year : now.getYear();

        MonthlyReportResponseDTO report = pocketService.getMonthlyReport(pocketId, targetMonth, targetYear);
        return ResponseEntity.ok(report);
    }
}
