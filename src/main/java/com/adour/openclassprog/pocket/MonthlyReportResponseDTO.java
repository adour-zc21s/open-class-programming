package com.adour.openclassprog.pocket;

import java.math.BigDecimal;
import java.util.List;
/*
 * @author {Riset Inovasi Ekosistem Komputasi}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/09/2026 - 19:15
 */
public record MonthlyReportResponseDTO(
        Long pocketId,
        String pocketName,
        int month,
        int year,
        BigDecimal totalIncome,    // Total (Gaji + Pemasukan Lain)
        BigDecimal totalExpense,   // Total Pengeluaran
        BigDecimal monthlyBalance, // Total Income - Total Expense
        List<PocketItem> items
) {}
