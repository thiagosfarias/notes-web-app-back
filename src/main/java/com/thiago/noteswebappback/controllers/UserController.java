package com.thiago.noteswebappback.controllers;

import com.thiago.noteswebappback.exceptions.ApiException;
import com.thiago.noteswebappback.exceptions.UserException;
import com.thiago.noteswebappback.models.User;
import com.thiago.noteswebappback.services.UserService;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws NoSuchAlgorithmException {
        try {
            User newUser = service.register(user);

            return Objects.isNull(newUser) ?
                    ResponseEntity.status(HttpStatus.CONFLICT).build() :
                    ResponseEntity.status(CREATED).body(newUser);
        } catch (ApiException apiException){
            throw new UserException(apiException.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        return ResponseEntity.ok().body(service.login(user));
    }

}
