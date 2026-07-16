package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.EmailDTO;
import com.adour.openclassprog.dto.TicketDTO;
import com.adour.openclassprog.model.Email;
import com.adour.openclassprog.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/07/2026 - 9:48
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EmailMap {
    EmailDTO toDTO(Email email);
    Email toEntity(EmailDTO emailDTO);
    List<EmailDTO> toDTOList(List<Email> emails);
    void updateEntityFromDTO(
            EmailDTO emailDTO,
            @MappingTarget Email email
    );
}
