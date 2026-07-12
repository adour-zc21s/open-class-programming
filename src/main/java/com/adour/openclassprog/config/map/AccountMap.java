package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.AccountDTO;
import com.adour.openclassprog.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/07/2026 - 21:56
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AccountMap {
    AccountDTO toDTO(Account account);
    Account toEntity(AccountDTO accountDTO);

    List<AccountDTO> toDTOList(List<Account> accounts);

    void updateEntityFromDto(
            AccountDTO accountDTO,
            @MappingTarget Account account);
}
