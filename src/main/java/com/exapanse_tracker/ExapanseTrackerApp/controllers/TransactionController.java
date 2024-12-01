package com.exapanse_tracker.ExapanseTrackerApp.controllers;

import com.exapanse_tracker.ExapanseTrackerApp.domain.transaction.Transaction;
import com.exapanse_tracker.ExapanseTrackerApp.dto.CreateTransactionRequestDTO;
import com.exapanse_tracker.ExapanseTrackerApp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody CreateTransactionRequestDTO body) {
        this.transactionService.createTransaction(body);

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @GetMapping("")
    public ResponseEntity<List<Transaction>> list() {

        List<Transaction> transactionList = this.transactionService.listAllTransactions();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-type", "application/json");

        return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(transactionList);
    }
}
