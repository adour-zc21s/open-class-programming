package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.dto.DeviceDTO;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 25/06/2026 - 10:13
 */
public interface DeviceService {
    DeviceDTO createDevice(DeviceDTO deviceDTO);
    List<DeviceDTO> getAllDevices();
    DeviceDTO getDeviceById(Long id);
    DeviceDTO updateDevice(Long id, DeviceDTO deviceDTO);
    void deleteDevice(Long id);
}
