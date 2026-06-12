package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.CrmDTO;
import com.adour.openclassprog.service.CrmService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/06/2026 - 13:20
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/crm/v1")
public class CrmController {
    private CrmService crmService;
    // http://localhost8081/api/crm/v1
    @PostMapping
    public ResponseEntity<CrmDTO> tambahCrm(@RequestBody CrmDTO crmDTO){
        try {
            CrmDTO simpanCrm = crmService.createCrm(crmDTO);
            return new ResponseEntity<>(simpanCrm, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new NoSuchElementException("Creation failed");
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<CrmDTO> rubahCrm(@PathVariable("id") Integer id, @RequestBody CrmDTO crmDTO){
        try {
            CrmDTO crmDTO1 = crmService.updateCrm(id, crmDTO);
            return ResponseEntity.ok(crmDTO1);
        } catch (Exception e) {
            throw new NoSuchElementException("Updating is failed");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<CrmDTO> getCrmById(@PathVariable Integer id){
        try {
            CrmDTO crmDTO = crmService.getCrmById(id);
            return new ResponseEntity<>(crmDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new NoSuchElementException("Getting by id is failed");
        }
    }
    @GetMapping
    public ResponseEntity<List<CrmDTO>> cariSemua(){
        try {
            // Cari ke data ke db
            List<CrmDTO> crmList = crmService.cariSemua();
            // Response hasil pencarian
            return new ResponseEntity<>(crmList, HttpStatus.OK);
        } catch (Exception e) {
            throw new NoSuchElementException("Getting all is failed");
        }
    }
    public ResponseEntity<Void> hapusCrm(@PathVariable("id") Integer id) {
        try {
            crmService.hapusCrmById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new NoSuchElementException(("Deleting is failed"));
        }
    }
}
