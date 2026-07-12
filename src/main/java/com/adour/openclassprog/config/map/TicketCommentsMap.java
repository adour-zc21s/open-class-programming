package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.TicketCommentDTO;
import com.adour.openclassprog.model.Ticket;
import com.adour.openclassprog.model.TicketComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 10/07/2026 - 8:55
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TicketCommentsMap {

    // Entity -> DTO (Keep this so the API response includes the ticketId)
    @Mapping(source = "ticket.id", target = "ticketId")
    TicketCommentDTO toDTO(TicketComment ticketComment);

    // DTO -> Entity (Ignore 'ticket' target here)
    @Mapping(target = "ticket", ignore = true)
    TicketComment toEntity(TicketCommentDTO ticketCommentDTO);

    List<TicketCommentDTO> toDTOList(List<TicketComment> ticketComments);

    // Update existing Entity (Ignore 'ticket' target here too)
    @Mapping(target = "ticket", ignore = true)
    void updateEntityFromDTO(
            TicketCommentDTO ticketCommentDTO,
            @MappingTarget TicketComment ticketComment
    );
}
