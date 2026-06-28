package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.AccountDTO;
import com.adour.openclassprog.service.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Map;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 22:18
 */
@RestController
@RequestMapping("/api/v1/acc")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API contains a secure ... method")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccount() {
        return ResponseEntity.ok(accountService.getAllAccount());
    }
    @PutMapping("/{id}/deposit")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id,
                                           @RequestBody Map<String, Double> request)
            throws AccountNotFoundException {
        // Extract amount service
        double amount = request.get("amount");
        // Let the service handle it. If it fails, the specific exception bubbles up.
        AccountDTO deposit = accountService.deposit(id, amount);
        return ResponseEntity.ok(deposit);
    }
    @PutMapping("/{id}/withdraw")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id,
                                             @RequestBody Map<String, Double> request)
            throws AccountNotFoundException {
        // Extract amount service
        double amount = request.get("amount");
        // Let the service handle it. If it fails, the specific exception bubbles up.
        AccountDTO withdraw = accountService.withdraw(id, amount);
        return ResponseEntity.ok(withdraw);
    }
}
