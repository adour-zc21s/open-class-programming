package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.CustomerDTO;
import com.adour.openclassprog.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 12:58
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/customer")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO created = customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
}
