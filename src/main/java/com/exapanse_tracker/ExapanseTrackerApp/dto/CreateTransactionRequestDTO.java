package com.exapanse_tracker.ExapanseTrackerApp.dto;

import com.exapanse_tracker.ExapanseTrackerApp.enums.TransactionType;

import java.math.BigDecimal;

public record CreateTransactionRequestDTO(String userId, int type, BigDecimal amount) {
}
