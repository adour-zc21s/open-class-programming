package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.BranchMap;
import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.model.Branch;
import com.adour.openclassprog.repository.BranchRepository;
import com.adour.openclassprog.service.BranchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 24/06/2026 - 17:32
 */
@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final BranchMap branchMap;

    // Constructor Injection
    public BranchServiceImpl(BranchRepository branchRepository, BranchMap branchMap) {
        this.branchRepository = branchRepository;
        this.branchMap = branchMap;
    }
    @Override
    public BranchDTO createBranch(BranchDTO branchDTO) {
        // 1. Check if the controller successfully passed the data
        System.out.println("Incoming DTO: " + branchDTO);

        Branch branch = branchMap.toEntity(branchDTO);

        // 2. Check if MapStruct successfully converted it to the entity
        System.out.println("Mapped Entity Name: " + branch.getName());

        Branch savedBranch = branchRepository.save(branch);
        return branchMap.toDTO(savedBranch);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BranchDTO> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branchMap.toDTOList(branches);
    }

    @Override
    @Transactional(readOnly = true)
    public BranchDTO getBranchById(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found with id: " + id));
        return branchMap.toDTO(branch);
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO) {
        Branch existingBranch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found with id: " + id));

        // Map changes directly onto the managed JPA entity
        branchMap.updateEntityFromDto(branchDTO, existingBranch);

        Branch updatedBranch = branchRepository.save(existingBranch);
        return branchMap.toDTO(updatedBranch);
    }

    @Override
    public void deleteBranch(Long id) {
        if (!branchRepository.existsById(id)) {
            throw new RuntimeException("Branch not found with id: " + id);
        }
        branchRepository.deleteById(id);
    }
}
