package com.adour.openclassprog.service;

import com.adour.openclassprog.config.map.BranchMap;
import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.model.Branch;
import com.adour.openclassprog.repository.BranchRepository;
import com.adour.openclassprog.service.impl.BranchServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 05/07/2026 - 18:37
 */
@ExtendWith(MockitoExtension.class)
class BranchServiceImplTest {
    @Mock
    private BranchRepository branchRepository;
    @Mock
    private BranchMap branchMap;
    @InjectMocks
    private BranchServiceImpl branchService;
    @Test
    void createBranch_ShouldSuccessfullyMapSaveAndReturnDTO() {
        // 1. Arrange
        BranchDTO inputDTO = new BranchDTO(
                null, "BR001", "New Branch", "PT. Open Class", "12.345.678.9",
                "ISP One", "08123", "ISP Two", "08124", "branch@adour.com", "Jakarta, Indonesia", "Main Hub"
        );

        Branch mockEntity = new Branch(); // Blank entity (ID is null before save)

        Branch savedEntity = new Branch();
        savedEntity.setId(1L); // Simulates database assigning an ID

        BranchDTO expectedDTO = new BranchDTO(
                1L, "BR001", "New Branch", "PT. Open Class", "12.345.678.9",
                "ISP One", "08123", "ISP Two", "08124", "branch@adour.com", "Jakarta, Indonesia", "Main Hub"
        );

        // Define mock behavior step-by-step
        when(branchMap.toEntity(inputDTO)).thenReturn(mockEntity);
        when(branchRepository.save(mockEntity)).thenReturn(savedEntity);
        when(branchMap.toDTO(savedEntity)).thenReturn(expectedDTO);

        // 2. Act
        BranchDTO result = branchService.createBranch(inputDTO);

        // 3. Assert
        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals("New Branch", result.name());

        // Verify that each mock interaction happened exactly once in sequence
        verify(branchMap, times(1)).toEntity(inputDTO);
        verify(branchRepository, times(1)).save(mockEntity);
        verify(branchMap, times(1)).toDTO(savedEntity);
    }

    @Test
    void getAllBranches_ShouldReturnListOfBranchDTOs_WhenBranchesExist() {
        // 1. Arrange
        Branch branch1 = new Branch();
        branch1.setId(1L);

        Branch branch2 = new Branch();
        branch2.setId(2L);

        List<Branch> mockBranchList = List.of(branch1, branch2);

        BranchDTO dto1 = new BranchDTO(
                1L, "BR001", "Branch One", "PT. Open Class", "12.345.678.9",
                "ISP One", "08123", "ISP Two", "08124", "branch1@adour.com", "Jakarta", "Hub 1"
        );
        BranchDTO dto2 = new BranchDTO(
                2L, "BR002", "Branch Two", "PT. Open Class", "12.345.678.9",
                "ISP One", "08123", "ISP Two", "08124", "branch2@adour.com", "Bandung", "Hub 2"
        );
        List<BranchDTO> expectedDTOList = List.of(dto1, dto2);

        // Define mock behaviors
        when(branchRepository.findAll()).thenReturn(mockBranchList);
        when(branchMap.toDTOList(mockBranchList)).thenReturn(expectedDTOList);

        // 2. Act
        List<BranchDTO> result = branchService.getAllBranches();

        // 3. Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Branch One", result.get(0).name());
        assertEquals("Branch Two", result.get(1).name());

        // Verify that the repository and mapper were called exactly once
        verify(branchRepository, times(1)).findAll();
        verify(branchMap, times(1)).toDTOList(mockBranchList);
    }

    @Test
    void getAllBranches_ShouldReturnEmptyList_WhenNoBranchesExist() {
        // 1. Arrange
        when(branchRepository.findAll()).thenReturn(List.of());
        when(branchMap.toDTOList(List.of())).thenReturn(List.of());

        // 2. Act
        List<BranchDTO> result = branchService.getAllBranches();

        // 3. Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(branchRepository, times(1)).findAll();
        verify(branchMap, times(1)).toDTOList(List.of());
    }
}
