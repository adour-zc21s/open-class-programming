package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.CrmDTO;
import com.adour.openclassprog.model.Crm;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/06/2026 - 13:12
 */
public interface CrmService {
    Crm createCrm(Crm crm);
    CrmDTO getCrmById(Integer id);
    List<CrmDTO> cariSemua();
    Crm updateCrm(Integer id, Crm updateCrm);
    void hapusCrmById(Integer id);
}
