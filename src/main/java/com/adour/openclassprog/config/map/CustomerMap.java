package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.CustomerDTO;
import com.adour.openclassprog.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 12:48
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerMap {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
    List<CustomerDTO> toDTOList(List<Customer> customers);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountNumber", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    void updateEntityFromDto(
            CustomerDTO customerDTO,
            @MappingTarget Customer customer
    );
}
