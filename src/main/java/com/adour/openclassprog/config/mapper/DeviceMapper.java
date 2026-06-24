package com.adour.openclassprog.config.mapper;

import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.model.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 24/06/2026 - 11:59
 */
@Mapper
public interface DeviceMapper {

    // The factory instantly resolves the generated implementation class
    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    DeviceDTO toDTO(Device device);

    @Mapping(target = "user", source = "user", qualifiedByName = "toUpperCase")
    Device toEntity(DeviceDTO deviceDTO);

    @Mapping(target = "user", source = "user", qualifiedByName = "toUpperCase")
    void updateEntityFromDto(DeviceDTO deviceDTO, @MappingTarget Device device);

    @Named("toUpperCase")
    default String toUpperCase(String value) {
        return value != null ? value.toUpperCase() : null;
    }
}
