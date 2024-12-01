package com.exapanse_tracker.ExapanseTrackerApp.repositories;

import com.exapanse_tracker.ExapanseTrackerApp.domain.transaction.Transaction;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Id> {
}
