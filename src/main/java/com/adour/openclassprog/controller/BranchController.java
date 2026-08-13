package com.adour.openclassprog.controller;

import com.adour.openclassprog.config.map.BranchMap;
import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.model.Branch;
import com.adour.openclassprog.repository.BranchRepository;
import com.adour.openclassprog.service.BranchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Map;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 24/06/2026 - 18:57
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/branches")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class BranchController {

    private final BranchService branchService;
    private final BranchRepository branchRepository;
    private final BranchMap branchMap;

    public BranchController(BranchService branchService,
                            BranchRepository branchRepository, BranchMap branchMap) {
        this.branchService = branchService;
        this.branchRepository = branchRepository;
        this.branchMap = branchMap;
    }

    @PostMapping
    public ResponseEntity<BranchDTO> createBranch(@RequestBody BranchDTO branchDTO) {
//        try {
//            BranchDTO simpanBranch = branchService.createBranch(branchDTO);
//            return new ResponseEntity<>(simpanBranch, HttpStatus.CREATED);
//        } catch (Exception er) {
//            throw new NoSuchElementException("Creation Account failed");
//        }
        BranchDTO created = branchService.createBranch(branchDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<List<BranchDTO>> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> getBranchById(@PathVariable Long id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchDTO> updateBranch(
            @PathVariable Long id,
            @RequestBody BranchDTO branchDTO) {
        return ResponseEntity.ok(branchService.updateBranch(id, branchDTO));
    }

    @GetMapping("/search")
    public List<BranchDTO> searchUsers(@RequestParam String letter) {
        // Calls the automatic case-insensitive containing query
        return branchRepository.findByNameContainingIgnoreCase(letter);
    }

//    @GetMapping("/search-paginated")
//    public Page<BranchDTO> searchUsersWithMetadata(
//            @RequestParam String letter,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Branch> branchPage = branchRepository.findByNameContainingIgnoreCase(letter, pageable);
//
//        // MapStruct maps individual items while preserving the Page container metadata
//        return branchPage.map(branchMap::toDTO);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }

    // Monitoring status
    @GetMapping("/{id}/status")
    public ResponseEntity<Map<String, Object>> checkBranchIpStatus(@PathVariable Long id) {
        // 1. Cari branch berdasarkan ID dari database
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch tidak ditemukan"));

        // 2. Ambil IP Public dari entity Branch
        String ipPublic = branch.getNoIsp1(); // penempatan IP Public ada di field database ini

        boolean isReachable = false;
        if (ipPublic != null && !ipPublic.isEmpty()) {
            // Alternatif pengecekan lewat Socket Port (Lebih Akurat untuk IP Public)
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(ipPublic, 8291), 3000); // Cek koneksi port 8291 dengan timeout 3 detik
                isReachable = true;
            } catch (IOException e) {
                isReachable = false;
            }
        }

        return ResponseEntity.ok(Map.of(
                "branchId", id,
                "ipPublic", ipPublic != null ? ipPublic : "-",
                "online", isReachable
        ));
    }
}
