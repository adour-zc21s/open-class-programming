package com.adour.openclassprog.dto;

import java.util.Date;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 25/06/2026 - 10:06
 */
public record DeviceDTO(
   Long id,
   String deviceName,
   String deviceType,
   String manufacture,
   String serialNumber,
   String ipAddress,
   String macAddress,
   String user,
   String description,
   Date purchaseDate,
   Date warrantyExpired
) {
}
