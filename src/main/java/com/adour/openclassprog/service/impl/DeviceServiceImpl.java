package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.DeviceMap;
import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.model.Device;
import com.adour.openclassprog.repository.DeviceRepository;
import com.adour.openclassprog.service.DeviceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 25/06/2026 - 10:15
 */
@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final DeviceMap deviceMap;

    public DeviceServiceImpl(DeviceRepository deviceRepository, DeviceMap deviceMap) {
        this.deviceRepository = deviceRepository;
        this.deviceMap = deviceMap;
    }

    @Override
    public DeviceDTO createDevice(DeviceDTO deviceDTO) {
        // 1. Check if the controller successfully passed the data
        System.out.println("Incoming DTO: " + deviceDTO);

        Device device = deviceMap.toEntity(deviceDTO);

        // 2. Check if MapStruct successfully converted it to the entity
        System.out.println("Mapped Entity Name: " + device.getDeviceName());

        Device savedDevice = deviceRepository.save(device);
        return deviceMap.toDTO(savedDevice);
    }

    @Override
    public List<DeviceDTO> getAllDevices() {
        List<Device> devices = deviceRepository.findAll();
        return deviceMap.toDTOList(devices);
    }

    @Override
    public DeviceDTO getDeviceById(Long id) {
        Device dv = deviceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account record not found with Account ID: " + id));
        return deviceMap.toDTO(dv);
    }
    @Override
    public List<DeviceDTO> searchDeviceByDeviceName(String deviceName) {
        List<Device> devices = deviceRepository.findByDeviceNameContainingIgnoreCase(deviceName);
        // 1. Check if the repository returned an empty list right here in the service
        if (devices.isEmpty()) {
            throw new NoSuchElementException("No device record found with name: " + deviceName);
        }
        return devices.stream()
                .map(deviceMap::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DeviceDTO updateDevice(Long id, DeviceDTO deviceDTO) {
        return null;
    }

    @Override
    public void deleteDevice(Long id) {

    }
}
