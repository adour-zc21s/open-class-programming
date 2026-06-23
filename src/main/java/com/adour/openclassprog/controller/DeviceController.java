package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.model.Device;
import com.adour.openclassprog.payload.res.WebResponse;
import com.adour.openclassprog.service.DeviceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 23/06/2026 - 10:04
 */
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/dev/v1")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class DeviceController {

    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<Device> tambahDevice(@RequestBody Device device) {
        try {
            Device simpanDevice = deviceService.createDevice(device);
            return new ResponseEntity<>(simpanDevice, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new NoSuchElementException("Creation Account failed");
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<List<DeviceDTO>> getAll() {
        try {
            List<DeviceDTO> deviceList = deviceService.getAll();
            return new ResponseEntity<>(deviceList, HttpStatus.OK);
        } catch (Exception er) {
            throw new NoSuchElementException("Getting all device failed");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDevById(@PathVariable Long id) {
        try {
            Device dv = deviceService.getDevById(id);
            return new ResponseEntity<>(dv, HttpStatus.OK);
        } catch (Exception adour) {
            throw new NoSuchElementException("Getting Account is failed");
        }
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<WebResponse<String>> hapusDevice(@PathVariable("id") Long id) {
        try {
            deviceService.deleteDevById(id);
            WebResponse<String> response = new WebResponse<>("Device deleted successfully", null);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new NoSuchElementException("Deleting Device is failed, try again");
        }
    }

}
