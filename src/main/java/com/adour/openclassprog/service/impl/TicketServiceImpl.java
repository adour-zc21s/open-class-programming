package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.TicketMap;
import com.adour.openclassprog.dto.TicketDTO;
import com.adour.openclassprog.model.Ticket;
import com.adour.openclassprog.repository.TicketRepository;
import com.adour.openclassprog.service.TicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.time.format.DateTimeFormatter;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 09/07/2026 - 17:35
 */
@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMap ticketMap;

    public TicketServiceImpl(TicketRepository ticketRepository, TicketMap ticketMap) {
        this.ticketRepository = ticketRepository;
        this.ticketMap = ticketMap;
    }

    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        // 1. Generate the date prefix (e.g., "TKT-20260710-")
        String datePrefix = "TKT-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";

        // 2. Query the DB for the highest sequence number used today
        String latestTicketNo = ticketRepository.findLatestTicketNoByPrefix(datePrefix).orElse(null);

        int nextSequence = 1;
        if (latestTicketNo != null) {
            // Extract the suffix sequence (e.g., "001" -> 1) and increment it
            String sequenceStr = latestTicketNo.substring(datePrefix.length());
            nextSequence = Integer.parseInt(sequenceStr) + 1;
        }

        // 3. Format the new ticket number with a 3-digit zero padding (e.g., "TKT-20260710-001")
        String generatedTicketNo = datePrefix + String.format("%03d", nextSequence);

        // 4. Map DTO to Entity and assign the generated ticket number
        Ticket ticket = ticketMap.toEntity(ticketDTO);
        ticket.setNoTiket(generatedTicketNo);
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());

        // 5. Save and return
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMap.toDTO(savedTicket);
    }

    @Override
    public TicketDTO getTicketById(Long id) {
        Ticket tiket = ticketRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ticket not found with ticket id: " + id));
        return ticketMap.toDTO(tiket);
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        List<Ticket> tiket = ticketRepository.findAll();
        return ticketMap.toDTOList(tiket);
    }

    @Override
    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        Ticket existingTiket = ticketRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ticket not found with id: " + id));
        ticketMap.updateEntityFromDTO(ticketDTO, existingTiket);
        return ticketMap.toDTO(ticketRepository.save(existingTiket));
    }

    @Override
    public void deleteTicket(Long id) {
        if(!ticketRepository.existsById(id)) {
            throw new NoSuchElementException("Ticket not found with id: " + id);
        }
        ticketRepository.deleteById(id);
    }
}
