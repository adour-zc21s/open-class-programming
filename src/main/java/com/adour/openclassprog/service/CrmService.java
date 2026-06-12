package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.CrmDTO;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/06/2026 - 13:12
 */
public interface CrmService {
    CrmDTO createCrm(CrmDTO crmDTO);
    CrmDTO getCrmById(Integer id);
    List<CrmDTO> cariSemua();
    CrmDTO updateCrm(Integer id, CrmDTO updateCrmDto);
    void hapusCrmById(Integer id);
}
