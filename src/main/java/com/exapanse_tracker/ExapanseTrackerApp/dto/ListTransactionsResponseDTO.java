package com.exapanse_tracker.ExapanseTrackerApp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ListTransactionsResponseDTO(
        Long id,
        LocalDateTime date,
        String institution,
        String account,
        String merchant,
        BigDecimal amount,
        String type,
        int categoryId,
        String category,
        Boolean isPending,
        Boolean isTransfer,
        Boolean isExpense,
        Boolean isEdited
) {
}
