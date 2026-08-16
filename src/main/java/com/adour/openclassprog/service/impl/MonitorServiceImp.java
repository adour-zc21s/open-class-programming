package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.MonitorMap;
import com.adour.openclassprog.dto.MonitorDTO;
import com.adour.openclassprog.model.Monitor;
import com.adour.openclassprog.repository.MonitorRepository;
import com.adour.openclassprog.service.MonitorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/08/2026 - 17:54
 */
@Service
@Transactional
public class MonitorServiceImp implements MonitorService {
    private final MonitorRepository monitorRepository;
    private final MonitorMap monitorMap;

    public MonitorServiceImp(MonitorRepository monitorRepository, MonitorMap monitorMap) {
        this.monitorRepository = monitorRepository;
        this.monitorMap = monitorMap;
    }

    @Override
    public MonitorDTO createMonitor(MonitorDTO monitorDTO) {
        Monitor monitor = monitorMap.toEntity(monitorDTO);
        Monitor simpanMonitor = monitorRepository.save(monitor);
        return monitorMap.toDTO(simpanMonitor);
    }

    @Override
    public List<MonitorDTO> getAllMonitor() {
        List<Monitor> monitors = monitorRepository.findAll();
        return monitorMap.toDTOList(monitors);
    }

    @Override
    public MonitorDTO getMonitorById(Long id) {
        Monitor monitor = monitorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aplikasi not found with id:" +id));
        return monitorMap.toDTO(monitor);
    }

    @Override
    public MonitorDTO updateMonitor(Long id, MonitorDTO monitorDTO) {
        Monitor cekExistingMonitor = monitorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aplikasi not found with id:" +id));
        monitorMap.updateEntityFromDto(monitorDTO, cekExistingMonitor);
        Monitor updateMonitor = monitorRepository.save(cekExistingMonitor);
        return monitorMap.toDTO(updateMonitor);
    }

    @Override
    public void deleteMonitor(Long id) {
        if (!monitorRepository.existsById(id)) {
            throw new RuntimeException("Aplikasi not found with id:" +id);
        }
        monitorRepository.deleteById(id);
    }
}
