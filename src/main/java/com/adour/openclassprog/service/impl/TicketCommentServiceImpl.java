package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.TicketCommentsMap;
import com.adour.openclassprog.dto.TicketCommentDTO;
import com.adour.openclassprog.model.Ticket;
import com.adour.openclassprog.model.TicketComment;
import com.adour.openclassprog.repository.TicketCommentsRepository;
import com.adour.openclassprog.repository.TicketRepository;
import com.adour.openclassprog.service.TicketCommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 09/07/2026 - 18:32
 */
@Service
@Transactional
public class TicketCommentServiceImpl implements TicketCommentService {
    private final TicketCommentsRepository ticketCommentsRepository;
    private final TicketRepository ticketRepository;
    private final TicketCommentsMap ticketCommentsMap;

    public TicketCommentServiceImpl(TicketCommentsRepository ticketCommentsRepository, TicketRepository ticketRepository, TicketCommentsMap ticketCommentsMap) {
        this.ticketCommentsRepository = ticketCommentsRepository;
        this.ticketRepository = ticketRepository;
        this.ticketCommentsMap = ticketCommentsMap;
    }

    @Override
    public TicketCommentDTO createComment(Long ticketId, TicketCommentDTO ticketCommentDTO) {
        // Find the parent Ticket to establish the relationship
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));
        TicketComment commentEntity = ticketCommentsMap.toEntity(ticketCommentDTO);
        commentEntity.setTicket(ticket);
        commentEntity.setCreatedAt(java.time.LocalDateTime.now());
        commentEntity.setUpdatedAt(java.time.LocalDateTime.now());
        TicketComment savedComment = ticketCommentsRepository.save(commentEntity);
        return ticketCommentsMap.toDTO(savedComment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketCommentDTO> getCommentsByTicketId(Long ticketId) {
        // Verify the ticket actually exists first
        if (!ticketRepository.existsById(ticketId)) {
            throw new RuntimeException("Ticket comment not found with id: " + ticketId);
        }
        // Fetch all comments matching the ticketId
        List<TicketComment> comments = ticketCommentsRepository.findAllByOrderByIdAsc();
        // Map the collection of entities to a clean list of DTOs
        return ticketCommentsMap.toDTOList(comments);
    }
}
