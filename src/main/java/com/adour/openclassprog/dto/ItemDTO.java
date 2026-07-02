package com.adour.openclassprog.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 13:44
 */
public record ItemDTO(
    String code,
    String name,
    String description,
    int stockQuantity,
    double unitPrice
) {
}
