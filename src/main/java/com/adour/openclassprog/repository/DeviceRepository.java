package com.adour.openclassprog.repository;

import com.adour.openclassprog.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 25/06/2026 - 10:12
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    // Automatically generates: SELECT * FROM device WHERE LOWER(device_name) LIKE LOWER('%?%')
    List<Device> findByDeviceNameContainingIgnoreCase(String deviceName);
    List<Device> findAllByOrderByIdDesc();
}
