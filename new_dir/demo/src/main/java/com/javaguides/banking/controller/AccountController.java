package com.javaguides.banking.controller;

import com.javaguides.banking.dto.Accountdto;
import com.javaguides.banking.service.Accountservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private Accountservice accountservice;

    public AccountController(Accountservice accountservice) {
        this.accountservice = accountservice;
    }
    @PostMapping
    public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
        return new ResponseEntity<>(accountservice.addAccount(accountdto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Accountdto> getAccountById(@PathVariable Long Id){
        Accountdto accountdto=accountservice.getAccount(Id);
        return ResponseEntity.ok(accountdto);
    }

    public ResponseEntity<Accountdto> deposit(@PathVariable Long Id, Map<String,Double> request){
        double amount=request.get("amount");`
        Accountdto accountdto=accountservice.deposit()

    }
}
