package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.model.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BranchMap { // Changed from 'class' to 'interface'

    default BranchDTO toDTO(Branch branch){
        if(branch == null) {
            return null;
        }
        return new BranchDTO(
                branch.getId(),
                branch.getCode(),
                branch.getName(),
                branch.getNamaPt(),
                branch.getNpwp(),
                branch.getNamaIsp1(),
                branch.getNoIsp1(),
                branch.getNamaIsp2(),
                branch.getNoIsp2(),
                branch.getEmailDigunakan(),
                branch.getAddress(),
                branch.getDescription()
        );
    }

    default Branch toEntity(BranchDTO dto) {
        if (dto == null){
            return null;
        }
        Branch branch = new Branch();
        branch.setId(dto.id());
        branch.setCode(dto.code());
        // Add other source mappings here if needed
        return branch;
    }

    default List<BranchDTO> toDTOList(List<Branch> branches) {
        if (branches == null) {
            return null;
        }
        return branches.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "branchName", ignore = true)
        // MapStruct will automatically generate this method's body
    void updateEntityFromDto(
            BranchDTO dto,
            @MappingTarget Branch branch);
}