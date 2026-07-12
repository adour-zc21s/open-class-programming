package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.TicketDTO;
import com.adour.openclassprog.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 09/07/2026 - 17:26
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TicketMap {
    TicketDTO toDTO(Ticket ticket);
    Ticket toEntity(TicketDTO ticketDTO);
    List<TicketDTO> toDTOList(List<Ticket> tickets);
    void updateEntityFromDTO(
            TicketDTO ticketDTO,
            @MappingTarget Ticket ticket
    );

}
