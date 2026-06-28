package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.enums.DeviceType;
import com.adour.openclassprog.service.DeviceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
    public ResponseEntity<List<DeviceDTO>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<DeviceDTO> getDeviceById(@PathVariable Long id){
        DeviceDTO deviceDTO = deviceService.getDeviceById(id);
        return ResponseEntity.ok(deviceDTO);
    }
//    http://localhost:8081/api/dev/search?name=device_name
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<List<DeviceDTO>> searchDeviceByDeviceName(
            @RequestParam("name") String deviceName) {
        // Throws the exception catch in service implementation
        List<DeviceDTO> devices = deviceService.searchDeviceByDeviceName(deviceName);
        return ResponseEntity.ok(devices);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DeviceDTO> updateDevice(
            @PathVariable Long id,
            @RequestBody DeviceDTO deviceDTO) {
        return ResponseEntity.ok(deviceService.updateDevice(id, deviceDTO));
    }
    // Standart RESTful design with response code HTTP 204 No Content
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Map<String, String>> deleteDevice(@PathVariable Long id) {
//        deviceService.deleteDevice(id);
//
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "Device successfully deleted");
//
//        return ResponseEntity.ok(response); // Sends HTTP 200 with JSON body
//    }
    @GetMapping("/types")
    public List<DeviceType> getDeviceTypes() {
        return Arrays.asList(DeviceType.values());
    }
}
