package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.BrandDTO;
import com.adour.openclassprog.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 11:08
 */
@Mapper(
        componentModel = "Spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BrandMap {
    BrandDTO toDTO(Brand brand);
    Brand toEntity(BrandDTO brandDTO);
    List<BrandDTO> toDoList(List<Brand> brand);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(
            BrandDTO brandDTO,
            @MappingTarget Brand brand
    );
}
