package com.exapanse_tracker.ExapanseTrackerApp.services;

import com.exapanse_tracker.ExapanseTrackerApp.domain.transaction.Transaction;
import com.exapanse_tracker.ExapanseTrackerApp.dto.CreateTransactionRequestDTO;
import com.exapanse_tracker.ExapanseTrackerApp.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void createTransaction(CreateTransactionRequestDTO transactionRequest) {
//        Transaction transaction = new Transaction();

//        transaction.setUserId(transactionRequest.userId());
//        transaction.setType(transactionRequest.type());
//        transaction.setAmount(transactionRequest.amount());
//        transaction.setCurrency("BRL");
//
//        this.transactionRepository.save(transaction);
    }

    public List<Transaction> listAllTransactions() {
        return this.transactionRepository.findAll();
    }
}
