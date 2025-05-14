package com.exapanse_tracker.ExapanseTrackerApp.controllers;

import com.exapanse_tracker.ExapanseTrackerApp.domain.Users;
import com.exapanse_tracker.ExapanseTrackerApp.dto.CreateUserRequestDTO;
import com.exapanse_tracker.ExapanseTrackerApp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody CreateUserRequestDTO body) {

        Users searchUsernameAndEmail = this.usersRepository.findByUsernameOrEmail(body.username(), body.email());

        if (searchUsernameAndEmail != null) {
            if (searchUsernameAndEmail.getUsername() != null && searchUsernameAndEmail.getUsername().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username " + body.username() + " is already exists.");
            }

            if (searchUsernameAndEmail.getEmail() != null && searchUsernameAndEmail.getEmail().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email " + body.email() + " is already exists.");
            }
        }

        try {
            Users user = new Users();

            user.setUsername(body.username());
            user.setEmail(body.email());

            this.usersRepository.save(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}
