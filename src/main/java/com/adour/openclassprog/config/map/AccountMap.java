package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.AccountDTO;
import com.adour.openclassprog.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 22:04
 */
@Component
@Mapper(
        componentModel = "Spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public class AccountMap {
//    AccountDTO toDTO(Account account);
//    Account toEntity(AccountDTO accountDTO);
//    List<AccountDTO> toDTOList(List<Account> accounts);
//    @Mapping(target = "id", ignore = true)
//    void updateEntityFromDTO(
//            AccountDTO accountDTO,
//            @MappingTarget Account account
//    );

    public AccountDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }

        // Pass values directly into the Record's constructor
        return new AccountDTO(
                account.getId(),
                account.getName(),
                account.getNik(),
                account.getBalance(),
                account.getAccountNumber(),
                account.getHp(),
                account.getAddress(),
                account.getEmail()
        );
    }

    /**
     * Maps an AccountDTO Record to an Account entity
     */
    public Account toEntity(AccountDTO dto) {
        if (dto == null) {
            return null;
        }

        Account account = new Account();
        // Notice Record getters do not use "get": it's .id() and .balance()
        account.setId(dto.id());
        account.setBalance(dto.balance());

        return account;
    }

    /**
     * Maps a List of Account entities to a List of AccountDTO Records
     */
    public List<AccountDTO> toDTOList(List<Account> accounts) {
        if (accounts == null) {
            return null;
        }
        return accounts.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
