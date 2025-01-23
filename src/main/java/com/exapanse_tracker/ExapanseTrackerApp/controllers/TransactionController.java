package com.exapanse_tracker.ExapanseTrackerApp.controllers;

import com.exapanse_tracker.ExapanseTrackerApp.domain.transaction.Transaction;
import com.exapanse_tracker.ExapanseTrackerApp.dto.CreateTransactionRequestDTO;
import com.exapanse_tracker.ExapanseTrackerApp.dto.ListTransactionsResponseDTO;
import com.exapanse_tracker.ExapanseTrackerApp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, List<ListTransactionsResponseDTO>>> list() {

        List<Transaction> transactionList = this.transactionService.listAllTransactions();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-type", "application/json");

        List<ListTransactionsResponseDTO> transactionListParsed = transactionList.stream().map(transaction -> new ListTransactionsResponseDTO(
                        transaction.getTransactionId(),
                        transaction.getCreatedAt(),
                        "",
                        "",
                        "",
                        transaction.getAmount(),
                        transaction.getType(),
                        1,
                        "",
                        false,
                        false,
                        false,
                        false
                ))
                .toList();

        Map<String, List<ListTransactionsResponseDTO>> response = Map.of("result", transactionListParsed);

        return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(response);
    }
}
