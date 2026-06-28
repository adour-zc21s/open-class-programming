package com.adour.openclassprog.dto;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 22:02
 */
public record AccountDTO(
    Long id,
    String name,
    String nik,
    Double balance,
    String accountNumber,
    String hp,
    String address,
    String email
) {
}
