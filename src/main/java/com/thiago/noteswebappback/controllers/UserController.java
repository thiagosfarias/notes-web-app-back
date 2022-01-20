package com.thiago.noteswebappback.controllers;

import com.thiago.noteswebappback.models.User;
import com.thiago.noteswebappback.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.ok().body(service.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        return ResponseEntity.ok().body(service.login(user));
    }
}
