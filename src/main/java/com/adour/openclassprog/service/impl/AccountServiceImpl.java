package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.dto.AccountDTO;
import com.adour.openclassprog.model.Account;
import com.adour.openclassprog.repository.AccountRepository;
import com.adour.openclassprog.service.AccountService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
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
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Account createAcc(Account acc) {
        if (acc.getName() != null) {
            acc.setName(acc.getName().toUpperCase());
        }
        acc = accRepository.save(acc);
        return modelMapper.map(acc, Account.class);
    }

    @Override
    public Account deposit(Long id, double amount) throws AccountNotFoundException {
        Account acc = accRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        double total = acc.getBalance() + amount;
        acc.setBalance(total);
        Account simpanAcc = accRepository.save(acc);
        return modelMapper.map(simpanAcc, Account.class);
    }

    @Override
    public Account withdraw(Long id, double amount) throws AccountNotFoundException {
        Account acc = accRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        if(acc.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }
        double total = acc.getBalance() - amount;
        acc.setBalance(total);
        Account simpanTransaksi = accRepository.save(acc);
        return modelMapper.map(simpanTransaksi, Account.class);
    }

    @Override
    public Account getAccById(Long id) {
        Account acc = accRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account record not found with Account ID: " + id));
        return modelMapper.map(acc, Account.class);
    }

    @Override
    public List<AccountDTO> ambilSemua() {
        List<Account> acc = accRepository.findAll();
        return acc.stream()
                .map(acc1 -> modelMapper.map(acc1, AccountDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO updateAcc(Long id, AccountDTO updateAccDTO) {
        Account existingAcc = accRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account ID not found"));
        // Maps updateCrmDto properties directly onto the existing entity, ignoring nulls
        modelMapper.map(updateAccDTO, existingAcc);
        Account updatedAcc1 = accRepository.save(existingAcc);
        return modelMapper.map(updatedAcc1, AccountDTO.class);
    }

    @Override
    public void hapusAccById(Long id) {
        Account existingAcc = accRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(id + "not found"));
        accRepository.delete(existingAcc);
    }
}
