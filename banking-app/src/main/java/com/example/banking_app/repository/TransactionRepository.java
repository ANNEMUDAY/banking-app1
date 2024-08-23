package com.example.banking_app.repository;


import com.example.banking_app.model.Account;
import com.example.banking_app.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

