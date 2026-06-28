package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.WilayahDTO;
import com.adour.openclassprog.service.WilayahService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/06/2026 - 10:10
 */
@RestController
@RequestMapping("/api/v1/wilayah")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API contains a secure ... method")
public class WilayahController {
    private final WilayahService wilayahService;

    public WilayahController(WilayahService wilayahService) {
        this.wilayahService = wilayahService;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<WilayahDTO> addWilayah(@RequestBody WilayahDTO wilayahDTO) {
        WilayahDTO simpan = wilayahService.createWilayah(wilayahDTO);
        return new ResponseEntity<>(simpan, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<WilayahDTO>> getAllWilayah() {
        return ResponseEntity.ok(wilayahService.getAllWilayah());
    }
    @PutMapping("/{id}")
    public ResponseEntity<WilayahDTO> updateWilayah(
            @PathVariable Long id,
            @RequestBody WilayahDTO wilayahDTO) {
        return ResponseEntity.ok(wilayahService.updateWilayah(id, wilayahDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<WilayahDTO> getWilayahById(
            @PathVariable Long id) {
        WilayahDTO wilDTO = wilayahService.getWilayahById(id);
        return ResponseEntity.ok(wilDTO);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<Void> deleteWilayahById(
            Long id){
        wilayahService.deleteWilayah(id);
        return ResponseEntity.noContent().build();
    }
}
