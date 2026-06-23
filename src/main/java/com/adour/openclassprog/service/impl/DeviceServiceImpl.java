package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.model.Device;
import com.adour.openclassprog.repository.DeviceRepository;
import com.adour.openclassprog.service.DeviceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 23/06/2026 - 9:23
 */
@Service
@AllArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Device createDevice(Device device) {
        if(device.getDeviceName() != null) {
            device.setDeviceName(device.getDeviceName().toUpperCase());
        }
        device = deviceRepository.save(device);
        return modelMapper.map(device, Device.class);
    }

    @Override
    public DeviceDTO updateDevice(Long id, DeviceDTO deviceDTO) {
        return null;
    }

    @Override
    public Device getDevById(Long id) {
        return null;
    }

    @Override
    public List<DeviceDTO> getAll() {
        List<Device> dev = deviceRepository.findAll();
        return dev.stream()
                .map(adur -> modelMapper.map(adur, DeviceDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDevById(Long id) {

    }
}
