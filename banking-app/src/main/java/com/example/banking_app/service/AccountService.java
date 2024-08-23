package com.example.banking_app.service;



import com.example.banking_app.model.Account;
import com.example.banking_app.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        account.setBalance(0.0);
        return accountRepository.save(account);
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
    public List<Account> getallaccounts(){
         return accountRepository.findAll();
    }

    public Account findbyid(Long Id){
        return accountRepository.findById(Id).orElse(null);
    }
}
