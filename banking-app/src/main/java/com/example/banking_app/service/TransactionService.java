package com.example.banking_app.service;

import com.example.banking_app.model.Account;
import com.example.banking_app.model.Transaction;
import com.example.banking_app.repository.AccountRepository;
import com.example.banking_app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Transaction deposit(String accountNumber, Double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setTransactionDate(new Date());
        transaction.setTransactionType("DEPOSIT");

        return transactionRepository.save(transaction);
    }

    public Transaction withdraw(String accountNumber, Double amount) throws Exception {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account.getBalance() < amount) {
            throw new Exception("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setTransactionDate(new Date());
        transaction.setTransactionType("WITHDRAWAL");

        return transactionRepository.save(transaction);
    }

    public List<Transaction> allTransactions(){
        return transactionRepository.findAll();
    }
//    public Account getsomethingnew(String accontNumber){
//        Account account=accountRepository.findByAccountNumber(accontNumber);
//        System.out.println(account);
//        return account;
//    }

    public List<Account> getsomethingnew(Double balance){
        return accountRepository.findByBalanceGreaterThan(balance);
    }

    public void deleteid(Long Id){
        transactionRepository.deleteById(Id);
    }

}
