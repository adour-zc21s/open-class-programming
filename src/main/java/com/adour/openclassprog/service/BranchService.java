package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.BranchDTO;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 24/06/2026 - 17:32
 */
public interface BranchService {
    BranchDTO createBranch(BranchDTO branchDTO);
    List<BranchDTO> getAllBranches();
    BranchDTO getBranchById(Long id);
    BranchDTO updateBranch(Long id, BranchDTO branchDTO);
    void deleteBranch(Long id);
}
