package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.WilayahMap;
import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.dto.WilayahDTO;
import com.adour.openclassprog.model.Wilayah;
import com.adour.openclassprog.repository.WilayahRepository;
import com.adour.openclassprog.service.WilayahService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/06/2026 - 9:58
 */
@Service
@Transactional
public class WilayahServiceImpl implements WilayahService {
    private final WilayahRepository wilayahRepository;
    private final WilayahMap wilayahMap;

    public WilayahServiceImpl(WilayahRepository wilayahRepository, WilayahMap wilayahMap) {
        this.wilayahRepository = wilayahRepository;
        this.wilayahMap = wilayahMap;
    }

    @Override
    public WilayahDTO createWilayah(WilayahDTO wilayahDTO) {
        Wilayah wil = wilayahMap.toEntity(wilayahDTO);
        Wilayah simpanWil = wilayahRepository.save(wil);
        return wilayahMap.toDTO(simpanWil);
    }

    @Override
    public List<WilayahDTO> getAllWilayah() {
        List<Wilayah> wil = wilayahRepository.findAll();
        return wilayahMap.toDTOList(wil);
    }

    @Override
    public WilayahDTO getWilayahById(Long id) {
        Wilayah wil = wilayahRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Wilayah record not found with Wilayah ID: " +id));
        return wilayahMap.toDTO(wil);
    }

    @Override
    public WilayahDTO updateWilayah(Long id, WilayahDTO wilayahDTO) {
        Wilayah existingWilayah = wilayahRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wilayah not found with id: " +id));
        wilayahMap.updateEntityFromDTO(wilayahDTO, existingWilayah);
        return wilayahMap.toDTO(wilayahRepository.save(existingWilayah));
    }

    @Override
    public void deleteWilayah(Long id) {
        if (!wilayahRepository.existsById(id)) {
            throw new NoSuchElementException("Wilayah not found with id: " +id);
        }
        wilayahRepository.deleteById(id);
    }
}
