package com.adour.openclassprog.dto;

import jakarta.persistence.Column;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 24/06/2026 - 17:27
 */
public record BranchDTO(
    Long id,
    String code,
    String name,
    String namaPt,
    String npwp,
    String namaIsp1,
    String noIsp1,
    String namaIsp2,
    String noIsp2,
    String emailDigunakan,
    String address,
    String description
) {}
