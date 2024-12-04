package com.exapanse_tracker.ExapanseTrackerApp.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionRequestDTO(UUID userId, String title, String description, String type,
                                          BigDecimal amount, Long iconId) {
}
