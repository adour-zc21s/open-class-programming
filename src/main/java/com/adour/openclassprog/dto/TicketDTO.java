package com.adour.openclassprog.dto;

import java.time.LocalDateTime;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 09/07/2026 - 17:10
 */
public record TicketDTO(
    Long id,
    String noTiket,
    String email,
    String departemen,
    String priority,
    String judul,
    String dibuatOleh,
    String emailNotification,
    String branch,
    String jenisDukungan,
    String description,
    String closingMessage,
    String status,
    Integer rating,
    LocalDateTime closedAt,
    String ditutupOleh,
    String komentar,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    LocalDateTime tglKomentar
) {

}
