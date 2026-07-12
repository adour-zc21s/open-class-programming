package com.adour.openclassprog.controller;

import com.adour.openclassprog.dto.TicketCommentDTO;
import com.adour.openclassprog.dto.TicketDTO;
import com.adour.openclassprog.service.TicketCommentService;
import com.adour.openclassprog.service.TicketService;
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
 * Created 09/07/2026 - 17:59
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/tickets")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class TicketController {
    private final TicketService ticketService;
    private final TicketCommentService ticketCommentService;

    public TicketController(TicketService ticketService, TicketCommentService ticketCommentService) {
        this.ticketService = ticketService;
        this.ticketCommentService = ticketCommentService;
    }
    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTicket(){
        return ResponseEntity.ok(ticketService.getAllTickets());
    }
    @PostMapping
    public ResponseEntity<TicketDTO> addTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO simpan = ticketService.createTicket(ticketDTO);
        return new ResponseEntity<>(simpan, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicket(
            @PathVariable Long id,
            @RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.ok(ticketService.updateTicket(id, ticketDTO));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
//    POST /api/tickets/{ticketId}/comments
    @PostMapping("/{ticketId}/comments")
    public ResponseEntity<TicketCommentDTO> createComment(
            @PathVariable Long ticketId,
            @RequestBody TicketCommentDTO ticketCommentDTO) {
        TicketCommentDTO createdComment = ticketCommentService.createComment(ticketId, ticketCommentDTO);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }
    @GetMapping("/{ticketId}/comments")
    public ResponseEntity<List<TicketCommentDTO>> getCommentsByTicketId(@PathVariable Long ticketId) {
        List<TicketCommentDTO> comments = ticketCommentService.getCommentsByTicketId(ticketId);
        return ResponseEntity.ok(comments);
    }
}
