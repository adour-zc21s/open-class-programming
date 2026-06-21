package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.AccountDTO;
import com.adour.openclassprog.model.Account;
import com.adour.openclassprog.payload.res.WebResponse;
import com.adour.openclassprog.service.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/06/2026 - 13:20
 */
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/acc/v1")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class AccController {
    private AccountService accService;
    // http://localhost8081/api/acc/v1
    @PostMapping
    public ResponseEntity<Account> tambahAcc(@RequestBody Account acc){
        try {
            Account simpanAcc = accService.createAcc(acc);
            return new ResponseEntity<>(simpanAcc, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new NoSuchElementException("Creation Account failed");
        }
    }
    @PutMapping("/{id}/deposit")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<Account> deposit(@PathVariable Long id,
                                           @RequestBody Map<String, Double> request)
                                            throws AccountNotFoundException {
        // Extract amount service
        double amount = request.get("amount");
        // Let the service handle it. If it fails, the specific exception bubbles up.
        Account deposit = accService.deposit(id, amount);
        return ResponseEntity.ok(deposit);
    }
    @PutMapping("/{id}/withdraw")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<Account> withdraw(@PathVariable Long id,
                                           @RequestBody Map<String, Double> request)
                                            throws AccountNotFoundException {
        // Extract amount service
        double amount = request.get("amount");
        // Let the service handle it. If it fails, the specific exception bubbles up.
        Account withdraw = accService.withdraw(id, amount);
        return ResponseEntity.ok(withdraw);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<AccountDTO> rubahAcc(@PathVariable Long id,
                                            @RequestBody AccountDTO accDTO){
        try {
            AccountDTO existingAcc = accService.updateAcc(id, accDTO);
            return ResponseEntity.ok(existingAcc);
        } catch (Exception e) {
            throw new NoSuchElementException("Updating Account failed");
        }
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<Account> getAccById(@PathVariable Long id){
        try {
            Account acc = accService.getAccById(id);
            return new ResponseEntity<>(acc, HttpStatus.OK);
        } catch (Exception e) {
            throw new NoSuchElementException("Getting Account is failed");
        }
    }
    @GetMapping
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<List<AccountDTO>> cariSemua(){
        try {
            // Cari ke data ke db
            List<AccountDTO> crmList = accService.cariSemua();
            // Response hasil pencarian
            return new ResponseEntity<>(crmList, HttpStatus.OK);
        } catch (Exception e) {
            throw new NoSuchElementException("Getting all Account failed");
        }
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<WebResponse<String>> hapusACc(@PathVariable("id") Long id) {
        try {
            accService.hapusAccById(id);
            WebResponse<String> response = new WebResponse<>("Account deleted successfully", null);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new NoSuchElementException("Deleting Account is failed");
        }
    }
}
