package com.exapanse_tracker.ExapanseTrackerApp.dto;

import java.math.BigDecimal;

public record CreateTransactionRequestDTO(String userId, String type, BigDecimal amount) {
}
