package com.javaguides.banking.service.impl;

import com.javaguides.banking.Mapper.Mapper;
import com.javaguides.banking.dto.Accountdto;
import com.javaguides.banking.entity.Account;
import com.javaguides.banking.repository.AccountRepository;
import com.javaguides.banking.service.Accountservice;
import org.springframework.stereotype.Service;

@Service
public class Accountserviceimpl implements Accountservice {
    private AccountRepository accountRepository;

    public Accountserviceimpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Accountdto addAccount(Accountdto accountdto) {
        Account account = Mapper.mapToAccount(accountdto);
        Account saveaccount = accountRepository.save(account);
        return Mapper.mapToAccountdto(saveaccount);
    }

    @Override
    public Accountdto getAccount(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account id not found"));
        return Mapper.mapToAccountdto(account);
    }

    @Override
    public Accountdto deposit(Long Id, double amount) {
        Account account=accountRepository.findById(Id).orElseThrow(()->new RuntimeException("Account id not found"));
        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedbalnce=accountRepository.save(account);
        return Mapper.mapToAccountdto(savedbalnce);
    }

}
