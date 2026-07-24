package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.AccountDTO;
import com.adour.openclassprog.dto.BranchDTO;
import com.adour.openclassprog.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 22:07
 */
public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO deposit(Long id, double amount) throws AccountNotFoundException;
    AccountDTO withdraw(Long id, double amount) throws AccountNotFoundException;
    List<AccountDTO> getAllAccount();
    AccountDTO getAccountById(Long id);
    AccountDTO updateAccount(Long id, AccountDTO accountDTO);
    void deleteAccount(Long id);
    public List<AccountDTO> getAccountAscending();
}
