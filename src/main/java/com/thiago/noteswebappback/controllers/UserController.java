package com.thiago.noteswebappback.controllers;

import com.thiago.noteswebappback.exceptions.UserException;
import com.thiago.noteswebappback.models.User;
import com.thiago.noteswebappback.services.UserService;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequiredArgsConstructor
public class UserController {
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws NoSuchAlgorithmException {
        try {
            service.register(user);
            return ResponseEntity.status(CREATED).build();
        } catch (UserException userException){
            throw new UserException("");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        return ResponseEntity.ok().body(service.login(user));
    }
}
