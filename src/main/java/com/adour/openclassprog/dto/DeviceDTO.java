package com.adour.openclassprog.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 23/06/2026 - 9:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {
    public Long id;
    private String deviceName;
    private String deviceType;
    private String manufacture;
    private String macAddress;
}
