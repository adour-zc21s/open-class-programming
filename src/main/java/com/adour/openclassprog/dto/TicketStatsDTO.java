package com.adour.openclassprog.dto;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 30/07/2026 - 13:21
 */
public record TicketStatsDTO(
        long total,
        long open,
        long pending,
        long closed
) {}
