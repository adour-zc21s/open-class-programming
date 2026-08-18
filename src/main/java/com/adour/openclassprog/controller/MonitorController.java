package com.adour.openclassprog.controller;

import com.adour.openclassprog.config.map.MonitorMap;
import com.adour.openclassprog.dto.MonitorDTO;
import com.adour.openclassprog.model.Branch;
import com.adour.openclassprog.model.Monitor;
import com.adour.openclassprog.repository.MonitorRepository;
import com.adour.openclassprog.service.MonitorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Map;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/08/2026 - 18:06
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/monitoring")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class MonitorController {
    private final MonitorService monitorService;
    private final MonitorRepository monitorRepository;
    private final MonitorMap monitorMap;

    public MonitorController(MonitorService monitorService, MonitorRepository monitorRepository, MonitorMap monitorMap) {
        this.monitorService = monitorService;
        this.monitorRepository = monitorRepository;
        this.monitorMap = monitorMap;
    }
    @PostMapping
    public ResponseEntity<MonitorDTO> createMonitor(@RequestBody MonitorDTO monitorDTO) {
        MonitorDTO create = monitorService.createMonitor(monitorDTO);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<List<MonitorDTO>> getAllMonitor() {
        return ResponseEntity.ok(monitorService.getAllMonitor());
    }
    @GetMapping("/{id}/status")
    public ResponseEntity<Map<String, Object>> checkMonitorIpStatus(@PathVariable Long id) {
        // 1. Cari aplikasi berdasarkan ID dari database
        Monitor monitor = monitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aplikasi tidak ditemukan dengan id:" +id));

        // 2. Ambil IP Public dari entity Monitor
        String ipPublic = monitor.getIp();
        String portStr = monitor.getPort();

        boolean isReachable = false;
        if (ipPublic != null && !ipPublic.isEmpty()) {
            // Alternatif pengecekan lewat Socket Port (Lebih Akurat untuk IP Public)
            try (Socket socket = new Socket()) {
                int port = Integer.parseInt(portStr.trim());
                socket.connect(new InetSocketAddress(ipPublic, port), 3000); // Cek koneksi port 8291 dengan timeout 3 detik
                isReachable = true;
            } catch (IOException e) {
                isReachable = false;
            }
        }

        return ResponseEntity.ok(Map.of(
                "Aplikasi ID", id,
                "ipPublic", ipPublic != null ? ipPublic : "-",
                "online", isReachable
        ));
    }
}
