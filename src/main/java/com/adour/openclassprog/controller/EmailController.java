package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.EmailDTO;
import com.adour.openclassprog.model.Email;
import com.adour.openclassprog.service.EmailService;
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
 * Created 16/07/2026 - 10:08
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/emails")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<EmailDTO> addEmail(@RequestBody EmailDTO emailDTO) {
        EmailDTO addEmail = emailService.createEmail(emailDTO);
        return new ResponseEntity<>(addEmail, HttpStatus.CREATED);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<List<EmailDTO>> getAllEmail() {
        return ResponseEntity.ok(emailService.getAllEmail());
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<EmailDTO> getEmailById(Long id) {
        EmailDTO emailDTO = emailService.getEmailById(id);
        return ResponseEntity.ok(emailDTO);
    }
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<List<EmailDTO>> searchByEmailAddress(
            @RequestParam("email") String emailAddress) {
        List<EmailDTO> emails = emailService.searchEmailByEmailAddress(emailAddress);
        return ResponseEntity.ok(emails);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmailDTO> updateEmail(
            @PathVariable Long id,
            @RequestBody EmailDTO emailDTO) {
        return ResponseEntity.ok(emailService.updateEmail(id, emailDTO));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<EmailDTO> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }
}
