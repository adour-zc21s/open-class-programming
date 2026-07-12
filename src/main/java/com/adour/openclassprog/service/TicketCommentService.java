package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.TicketCommentDTO;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 09/07/2026 - 18:30
 */
public interface TicketCommentService {
    TicketCommentDTO createComment(Long ticketId, TicketCommentDTO ticketCommentDTO);
    List<TicketCommentDTO> getCommentsByTicketId(Long ticketId);
}
