package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.AccountDTO;
import com.adour.openclassprog.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/06/2026 - 13:12
 */
public interface AccountService {
    Account createAcc(Account acc);
    Account deposit(Long id, double amount) throws AccountNotFoundException;
    Account withdraw(Long id, double amount) throws AccountNotFoundException;
    Account getAccById(Long id);
    List<AccountDTO> cariSemua();
    AccountDTO updateAcc(Long id, AccountDTO updateAccDTO);
    void hapusAccById(Long id);
}
