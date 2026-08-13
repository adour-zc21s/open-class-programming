package com.adour.openclassprog.dto;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 13/08/2026 - 14:30
 */
public record ItemDTO(
    Long id,
    String code,
    String name,
    Double price,
    Integer stockQuantity,
    String description
) {
}
