package com.exapanse_tracker.ExapanseTrackerApp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ListTransactionsResponseDTO(
        Long id,
        LocalDateTime date,
        String title,
        String description,
        BigDecimal amount,
        String type,
        int categoryId,
        String category
) {
}
