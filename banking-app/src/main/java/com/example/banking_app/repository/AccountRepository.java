package com.example.banking_app.repository;


import com.example.banking_app.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumber(String accountNumber);
    List<Account> findByBalanceGreaterThan(Double balance);
}
