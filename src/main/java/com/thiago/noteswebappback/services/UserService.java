package com.thiago.noteswebappback.services;

import com.thiago.noteswebappback.models.User;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public interface UserService {
    User register(User user) throws NoSuchAlgorithmException;
    User login(User user);
    User findUser(UUID uuid);
    Boolean verifyEmail(String email);
}
