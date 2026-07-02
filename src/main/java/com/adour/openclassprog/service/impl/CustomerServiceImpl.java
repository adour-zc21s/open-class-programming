package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.CustomerMap;
import com.adour.openclassprog.dto.CustomerDTO;
import com.adour.openclassprog.model.Customer;
import com.adour.openclassprog.repository.CustomerRepository;
import com.adour.openclassprog.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 12:53
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMap customerMap;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMap customerMap) {
        this.customerRepository = customerRepository;
        this.customerMap = customerMap;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer cust = customerMap.toEntity(customerDTO);
        Customer saveCust = customerRepository.save(cust);
        return customerMap.toDTO(saveCust);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> list = customerRepository.findAll();
        return customerMap.toDTOList(list);
    }
}
