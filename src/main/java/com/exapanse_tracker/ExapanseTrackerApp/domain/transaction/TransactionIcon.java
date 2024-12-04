package com.exapanse_tracker.ExapanseTrackerApp.domain.transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions_icon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionIcon {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionIconId;

    private String name;

    private String path;
}