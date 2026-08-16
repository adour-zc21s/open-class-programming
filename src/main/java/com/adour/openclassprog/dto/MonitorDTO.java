package com.adour.openclassprog.dto;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/08/2026 - 17:41
 */
public record MonitorDTO(
     Long id,
     String monitorName,
     String ip,
     String port,
     String description
) {
}
