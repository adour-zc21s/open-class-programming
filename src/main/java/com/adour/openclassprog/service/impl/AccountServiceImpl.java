package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.AccountMap;
import com.adour.openclassprog.dto.AccountDTO;
import com.adour.openclassprog.model.Account;
import com.adour.openclassprog.repository.AccountRepository;
import com.adour.openclassprog.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 22:10
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMap accountMap;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMap accountMap) {
        this.accountRepository = accountRepository;
        this.accountMap = accountMap;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO deposit(Long id, double amount) throws AccountNotFoundException {
        Account acc = accountRepository.findById(id)
                .orElseThrow(()-> new AccountNotFoundException("Account not found with id: " + id));
        double total = acc.getBalance() + amount;
        acc.setBalance(total);
        Account simpan = accountRepository.save(acc);
        return accountMap.toDTO(simpan);
    }

    @Override
    public AccountDTO withdraw(Long id, double amount) throws AccountNotFoundException {
        Account acc = accountRepository.findById(id)
                .orElseThrow(()-> new AccountNotFoundException("Account not found with id: " + id));
        if(acc.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }
        double total = acc.getBalance() - amount;
        acc.setBalance(total);
        Account simpan = accountRepository.save(acc);
        return accountMap.toDTO(simpan);
    }

    @Override
    public List<AccountDTO> getAllAccount() {
        List<Account> acc = accountRepository.findAll();
        return accountMap.toDTOList(acc);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        return null;
    }

    @Override
    public AccountDTO updateAccount(Long id, AccountDTO accountDTO) {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {

    }
}
