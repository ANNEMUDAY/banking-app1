package com.example.banking_app.controller;


import com.example.banking_app.model.Account;
import com.example.banking_app.model.Transaction;
import com.example.banking_app.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> deposit(@RequestParam String accountNumber, @RequestParam Double amount) {
        return ResponseEntity.ok(transactionService.deposit(accountNumber, amount));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam String accountNumber, @RequestParam Double amount) {
        try {
             ResponseEntity.ok(transactionService.withdraw(accountNumber, amount));
             return new ResponseEntity<>("Successful",HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Insufficiant funds",HttpStatus.CREATED);
        }
    }
    @GetMapping("allTransactions")
    public List<Transaction> getall(){
        return transactionService.allTransactions();
    }

    @GetMapping("transA")
    public List<Account> getDetails(@RequestParam Double balance){
       return transactionService.getsomethingnew(balance);
    }
    @DeleteMapping("delete/{Id}")

    public void deleteTransaction(@PathVariable Long Id){
        transactionService.deleteid(Id);

    }
}
