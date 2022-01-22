package com.thiago.noteswebappback.services;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;


public interface EncryptService {
    String encode(String password) throws NoSuchAlgorithmException;
}
