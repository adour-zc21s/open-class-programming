package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.model.Branch;
import com.adour.openclassprog.model.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 25/06/2026 - 10:08
 */
@Mapper(componentModel = "spring")
public interface DeviceMap {
    DeviceDTO toDTO(Device device);

    @Mapping(source = "deviceName", target = "deviceName")
    @Mapping(source = "deviceType", target = "deviceType")
    @Mapping(source = "user", target = "user")
    Device toEntity(DeviceDTO deviceDTO);

    List<DeviceDTO> toDTOList(List<Device> devices);

    // Useful for PUT/PATCH updates
    void updateEntityFromDto(DeviceDTO deviceDTO, @MappingTarget Device device);
}
