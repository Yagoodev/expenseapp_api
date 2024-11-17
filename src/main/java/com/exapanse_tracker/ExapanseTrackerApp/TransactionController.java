package com.exapanse_tracker.ExapanseTrackerApp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
@RequestMapping("/")
public class TransactionController {

    @GetMapping("/")
    public ResponseEntity<String> getTransactions() {
        JSONArray transactions = new JSONArray();

        int randomNumber = (int) (Math.floor(Math.random() * 2));

        NumberFormat formatter = new DecimalFormat("#0.00");

        String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());

        for (int i = 1; i < 20; i++) {
            JSONObject transaction = new JSONObject();

            transaction.put("id", i);
            transaction.put("date", currentDate);
            transaction.put("institution", "Desjardins");
            transaction.put("account", randomNumber == 1 ? "Visa Desjardins" : "Personal Chequing Account");
            transaction.put("merchant", randomNumber == 1 ? "uber.com" : "Payment");
            transaction.put("amount", Double.parseDouble(formatter.format(Math.random() * 101)));
            transaction.put("type", randomNumber == 1 ? "debit" : "credit");
            transaction.put("categoryId", 100 + i);
            transaction.put("category", randomNumber == 1 ? "Taxi" : "Uber");
            transaction.put("isPending", randomNumber == 1);
            transaction.put("isTransfer", randomNumber == 0);
            transaction.put("isExpense", randomNumber == 1);
            transaction.put("isEdited", randomNumber == 0);

            transactions.put(transaction);
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-type", "application/json");

        return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(transactions.toString());
    }
}
