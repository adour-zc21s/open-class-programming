package com.adour.openclassprog.dto;

import jakarta.persistence.Column;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 12:45
 */
public record CustomerDTO(
    Long id,
    String title,
     String firstName,
     String hp,
     String email,
     String address
) {
}
