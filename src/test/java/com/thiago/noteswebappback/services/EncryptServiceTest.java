package com.thiago.noteswebappback.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.security.NoSuchAlgorithmException;


@RunWith(MockitoJUnitRunner.class)
public class EncryptServiceTest {
    private EncryptService service;

    @Before
    public void setUp(){
        service = new IEncryptService();
    }

    @Test
    public void mustEncodePasswordWithSucess() throws NoSuchAlgorithmException {
        String password = "tEste#87Passw0rd";

        String hash = service.encode(password);

        Assertions.assertNotNull(hash);
    }

}
