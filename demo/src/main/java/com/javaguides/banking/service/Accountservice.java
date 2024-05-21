package com.javaguides.banking.service;

import com.javaguides.banking.dto.Accountdto;


public interface Accountservice {
    Accountdto addAccount(Accountdto accountdto);
    Accountdto getAccount(Long id);
    Accountdto deposit(Long Id,double balance);
}
