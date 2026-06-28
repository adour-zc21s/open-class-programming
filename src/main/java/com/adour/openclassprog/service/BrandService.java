package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.BrandDTO;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 11:13
 */
public interface BrandService {
    BrandDTO createBrand(BrandDTO brandDTO);
    List<BrandDTO> getAllBrand();
    BrandDTO getBrandById(Long id);
    BrandDTO updateBrand(Long id, BrandDTO brandDTO);
    void deleteBrand(Long id);
}
