package com.adour.openclassprog.dto;

import java.time.LocalDateTime;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 09/07/2026 - 17:17
 */
public record TicketCommentDTO(
    Long id,
    Long ticketId,
    String comment,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
