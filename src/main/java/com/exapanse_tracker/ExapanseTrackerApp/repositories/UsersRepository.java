package com.exapanse_tracker.ExapanseTrackerApp.repositories;

import com.exapanse_tracker.ExapanseTrackerApp.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
    Users findByUsernameOrEmail(String username, String email);
}
