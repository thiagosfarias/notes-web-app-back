package com.thiago.noteswebappback.services;

import com.thiago.noteswebappback.models.User;

import java.security.NoSuchAlgorithmException;


public interface UserService {
    User register(User user) throws NoSuchAlgorithmException;
    User login(User user);
    Boolean verifyEmail(String email);
}
