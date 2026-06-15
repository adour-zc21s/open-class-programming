package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.dto.CrmDTO;
import com.adour.openclassprog.model.Crm;
import com.adour.openclassprog.repository.CrmRepository;
import com.adour.openclassprog.service.CrmService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/06/2026 - 13:13
 */

@Service
@AllArgsConstructor
public class CrmServiceImpl implements CrmService {

    @Autowired
    private CrmRepository crmRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CrmDTO createCrm(CrmDTO crmDTO) {
        // Converts a Transfer Object (DTO) into a JPA Entity using ModelMapper
        Crm crm = modelMapper.map(crmDTO, Crm.class);
        crm = crmRepository.save(crm);
        return modelMapper.map(crm, CrmDTO.class);
    }

    @Override
    public CrmDTO getCrmById(Integer id) {
        Crm crm = crmRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("CRM record not found with ID: " + id));
        return modelMapper.map(crm, CrmDTO.class);
    }

    @Override
    public List<CrmDTO> cariSemua() {
        List<Crm> crm = crmRepository.findAll();
        return crm.stream()
                .map(crm1 -> modelMapper.map(crm1, CrmDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CrmDTO updateCrm(Integer id, CrmDTO updateCrmDto) {
        Crm existingCrm = crmRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ID not found"));
        // Maps updateCrmDto properties directly onto the existing entity, ignoring nulls
        modelMapper.map(updateCrmDto, existingCrm);
        Crm updatedCrm = crmRepository.save(existingCrm);
        return modelMapper.map(updatedCrm, CrmDTO.class);
    }

    @Override
    public void hapusCrmById(Integer id) {
        Crm existingCrm = crmRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(id + "not found"));
        crmRepository.delete(existingCrm);
    }
}
