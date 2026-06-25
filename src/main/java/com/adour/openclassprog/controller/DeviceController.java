package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.enums.DeviceType;
import com.adour.openclassprog.model.Account;
import com.adour.openclassprog.model.Device;
import com.adour.openclassprog.service.BranchService;
import com.adour.openclassprog.service.DeviceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 25/06/2026 - 10:22
 */
@RestController
@RequestMapping("/api/v1/dev")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<DeviceDTO> addDevice(@RequestBody DeviceDTO deviceDTO) {
        DeviceDTO created = deviceService.createDevice(deviceDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<List<DeviceDTO>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<DeviceDTO> getAccById(@PathVariable Long id){
        DeviceDTO device = deviceService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }
    @GetMapping("/types")
    public List<DeviceType> getDeviceTypes() {
        return Arrays.asList(DeviceType.values());
    }
}
