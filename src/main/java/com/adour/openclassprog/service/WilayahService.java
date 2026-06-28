package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.dto.WilayahDTO;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/06/2026 - 9:50
 */
public interface WilayahService {
    WilayahDTO createWilayah(WilayahDTO wilayahDTO);
    List<WilayahDTO> getAllWilayah();
    WilayahDTO getWilayahById(Long id);
    WilayahDTO updateWilayah(Long id, WilayahDTO wilayahDTO);
    void deleteWilayah(Long id);
}
