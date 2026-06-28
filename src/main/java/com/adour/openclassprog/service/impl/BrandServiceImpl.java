package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.BrandMap;
import com.adour.openclassprog.dto.BrandDTO;
import com.adour.openclassprog.model.Brand;
import com.adour.openclassprog.repository.BrandRepository;
import com.adour.openclassprog.service.BrandService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 11:15
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMap brandMap;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMap brandMap) {
        this.brandRepository = brandRepository;
        this.brandMap = brandMap;
    }

    @Override
    public BrandDTO createBrand(BrandDTO brandDTO) {
        Brand br = brandMap.toEntity(brandDTO);
        Brand simpanBrand = brandRepository.save(br);
        return brandMap.toDTO(simpanBrand);
    }

    @Override
    public List<BrandDTO> getAllBrand() {
        List<Brand> brand = brandRepository.findAll();
        return brandMap.toDoList(brand);
    }

    @Override
    public BrandDTO getBrandById(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Brand record not found with Brand ID: " +id));
        return brandMap.toDTO(brand);
    }

    @Override
    public BrandDTO updateBrand(Long id, BrandDTO brandDTO) {
        Brand existingBrand = brandRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Brand record not found with Brand ID: " +id));
        return brandMap.toDTO(brandRepository.save(existingBrand));
    }

    @Override
    public void deleteBrand(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new NoSuchElementException("Brand not found with ID: " +id);
        }
        brandRepository.deleteById(id);
    }
}
