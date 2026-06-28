package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.dto.WilayahDTO;
import com.adour.openclassprog.model.Wilayah;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/06/2026 - 9:52
 */
@Mapper(
        componentModel = "Spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface WilayahMap {
    WilayahDTO toDTO(Wilayah wilayah);
    Wilayah toEntity(WilayahDTO wilayahDTO);
    List<WilayahDTO> toDTOList(List<Wilayah> wilayah);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(
            WilayahDTO wilayahDTO,
            @MappingTarget Wilayah wilayah
    );
}
