package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.dto.TicketDTO;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 09/07/2026 - 17:34
 */
public interface TicketService {
    TicketDTO createTicket(TicketDTO ticketDTO);
    TicketDTO getTicketById(Long id);
    List<TicketDTO> getAllTickets();
    TicketDTO updateTicket(Long id, TicketDTO ticketDTO);
    void deleteTicket(Long id);
    TicketDTO closeTicket(Long id);
}
