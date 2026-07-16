package com.adour.openclassprog.dto;

import jakarta.persistence.Column;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/07/2026 - 9:46
 */
public record EmailDTO(
    Long id,
    String email,
    String passwd
) {
}
