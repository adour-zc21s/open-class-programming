package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 12:52
 */
public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomer();
}
