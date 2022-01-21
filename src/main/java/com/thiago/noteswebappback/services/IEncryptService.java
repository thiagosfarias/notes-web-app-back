package com.thiago.noteswebappback.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class IEncryptService implements EncryptService{
    @Override
    public String encode(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] message = messageDigest.digest(password.getBytes());
        BigInteger number = new BigInteger(1, message);
        return number.toString(16);
    }
}
