package com.javaguides.banking.Mapper;

import com.javaguides.banking.dto.Accountdto;
import com.javaguides.banking.entity.Account;

public class Mapper {
    public static Account mapToAccount(Accountdto accountdto){
        Account account = new Account(accountdto.getId(), accountdto.getName(), accountdto.getBalance());
        return account;
    }
    public static Accountdto mapToAccountdto(Account account){
        Accountdto accountdto = new Accountdto(account.getId(), account.getName(), account.getBalance());
        return accountdto;
    }
}
