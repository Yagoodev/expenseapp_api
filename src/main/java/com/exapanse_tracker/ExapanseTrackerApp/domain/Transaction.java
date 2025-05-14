package com.exapanse_tracker.ExapanseTrackerApp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinColumn(name = "userId")
    private Users users;

    private String title;

    private String description;

    @Column(nullable = false)
    private String type;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(length = 3, nullable = false)
    private String currency;

    @ManyToMany
    @JoinColumn(name = "transactionIconId")
    private TransactionIcon transactionIcon;
}
