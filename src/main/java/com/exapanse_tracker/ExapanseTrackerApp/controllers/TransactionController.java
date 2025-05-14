package com.exapanse_tracker.ExapanseTrackerApp.controllers;

import com.exapanse_tracker.ExapanseTrackerApp.domain.Transaction;
import com.exapanse_tracker.ExapanseTrackerApp.dto.CreateTransactionRequestDTO;
import com.exapanse_tracker.ExapanseTrackerApp.dto.ListTransactionsResponseDTO;
import com.exapanse_tracker.ExapanseTrackerApp.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody CreateTransactionRequestDTO body) {
        Transaction transaction = new Transaction();

        transaction.setTitle(body.title());
        transaction.setDescription(body.description());
        transaction.setType(body.type());
        transaction.setAmount(body.amount());
        transaction.setCurrency("BRL");

        this.transactionRepository.save(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @GetMapping("")
    public ResponseEntity<Map<String, List<ListTransactionsResponseDTO>>> list() {

        List<Transaction> transactionList = this.transactionRepository.findAll();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-type", "application/json");

        List<ListTransactionsResponseDTO> transactionListParsed = transactionList.stream().map(transaction -> new ListTransactionsResponseDTO(transaction.getTransactionId(), transaction.getCreatedAt(), transaction.getTitle(), transaction.getDescription(), transaction.getAmount(), transaction.getType(), 1, "")).toList();

        Map<String, List<ListTransactionsResponseDTO>> response = Map.of("result", transactionListParsed);

        return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(response);
    }
}
