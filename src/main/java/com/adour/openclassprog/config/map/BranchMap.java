package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.model.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BranchMap {

    // If your Entity field is named 'branchName' instead of 'name'
    BranchDTO toDTO(Branch branch);

    Branch toEntity(BranchDTO dto);

    List<BranchDTO> toDTOList(List<Branch> branches);

    void updateEntityFromDto(BranchDTO dto, @MappingTarget Branch branch);
}