package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.BrandDTO;
import com.adour.openclassprog.model.Brand;
import com.adour.openclassprog.service.BrandService;
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
 * Created 28/06/2026 - 11:24
 */
@RestController
@RequestMapping("/api/v1/brand")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = " The Authorization API contain a secure methode")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<BrandDTO> createBrand(
            @RequestBody BrandDTO brandDTO) {
        BrandDTO simpan = brandService.createBrand(brandDTO);
        return new ResponseEntity<>(simpan, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BrandDTO>> getAllBrand() {
        return ResponseEntity.ok(brandService.getAllBrand());
    }
}
