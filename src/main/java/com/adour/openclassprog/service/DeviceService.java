package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.model.Device;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 23/06/2026 - 9:18
 */
public interface DeviceService {
    Device createDevice(Device device);
    DeviceDTO updateDevice(Long id, DeviceDTO deviceDTO);
    Device getDevById(Long id);
    List<DeviceDTO> getAll();
    void deleteDevById(Long id);
}
