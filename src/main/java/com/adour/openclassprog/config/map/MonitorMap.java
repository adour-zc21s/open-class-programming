package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.MonitorDTO;
import com.adour.openclassprog.model.Monitor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/08/2026 - 17:44
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MonitorMap {
    MonitorDTO toDTO(Monitor monitor);
    Monitor toEntity(MonitorDTO dto);
    List<MonitorDTO> toDTOList(List<Monitor> monitors);
    void updateEntityFromDto(MonitorDTO dto, @MappingTarget Monitor monitor);
}
