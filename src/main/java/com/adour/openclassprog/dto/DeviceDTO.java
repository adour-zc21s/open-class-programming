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
   String inventoryCode,
   String deviceName,
   String password,
   String passwordPortal,
   String deviceType,
   String manufacture,
   String serialNumber,
   String ipAddress,
   String macAddress,
   String location,
   String user,
   String branchName,
   String description,
   Date purchaseDate,
   Date warrantyExpired
) {
}
