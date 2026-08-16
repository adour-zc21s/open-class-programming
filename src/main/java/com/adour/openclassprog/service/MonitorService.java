package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.MonitorDTO;
import java.util.List;
/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/08/2026 - 17:49
 */
public interface MonitorService {
    MonitorDTO createMonitor(MonitorDTO monitorDTO);
    List<MonitorDTO> getAllMonitor();
    MonitorDTO getMonitorById(Long id);
    MonitorDTO updateMonitor(Long id, MonitorDTO monitorDTO);
    void deleteMonitor(Long id);

}
