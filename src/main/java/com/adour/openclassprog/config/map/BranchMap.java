package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.model.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 24/06/2026 - 17:27
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BranchMap {
    BranchDTO toDTO(Branch branch);
    Branch toEntity(BranchDTO branchDTO);
    List<BranchDTO> toDTOList(List<Branch> branches);

    // Useful for PUT/PATCH updates
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(
            BranchDTO branchDTO,
            @MappingTarget Branch branch);
}
