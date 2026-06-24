package com.adour.openclassprog.config.mapper;

import com.adour.openclassprog.dto.AccountDTO;
import com.adour.openclassprog.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 24/06/2026 - 11:57
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO toDTO(Account account);

    @Mapping(target = "name", source = "name", qualifiedByName = "toUpperCase")
    Account toEntity(AccountDTO accountDTO);

    @Named("toUpperCase")
    default String toUpperCase(String value) {
        return value != null ? value.toUpperCase() : null;
    }
}
