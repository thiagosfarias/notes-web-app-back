package com.thiago.noteswebappback.services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.thiago.noteswebappback.mapper.UserMapper;
import com.thiago.noteswebappback.models.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.security.NoSuchAlgorithmException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserMapper mapper;
    @Mock
    private IEncryptService encryptService;
    @InjectMocks
    private IUserService service;

    @Test
    public void mustRegisterANewUserWithSucess() throws NoSuchAlgorithmException {
        User user = User.builder().name("Teste").email("teste@email.com").password("teste123").build();

        User userRegistered = service.register(user);

        verify(mapper, times(1)).insert(any());

        Assertions.assertNotNull(userRegistered.getUuid());
    }

    @Test
    public void mustReturnFalseIfEmailExist() throws NoSuchAlgorithmException {
        User user = User.builder().email("teste@gmail.com").build();

        when(mapper.verifyEmail(user.getEmail())).thenReturn(user.getEmail());

        Boolean exist = service.verifyEmail(user.getEmail());

        Assertions.assertFalse(exist);

        verify(mapper, times(1)).verifyEmail(any());
    }

    @Test
    public void mustReturnTrueIfEmailDontExist() throws NoSuchAlgorithmException {
        User user = User.builder().email("teste@gmail.com").build();

        when(mapper.verifyEmail(user.getEmail())).thenReturn(null);

        Boolean exist = service.verifyEmail(user.getEmail());

        Assertions.assertTrue(exist);

        verify(mapper, times(1)).verifyEmail(any());
    }

    @Test
    public void mustLoginWithSucess(){
        User user = User.builder().email("teste@gmail.com").password("teste123").build();

        when(mapper.login(user)).thenReturn(user);

        User userLogged = service.login(user);

        Assertions.assertNotNull(userLogged);

        verify(mapper, times(1)).login(any());
    }

    @Test
    public void mustNotLogin(){
        User user = User.builder().email("teste@gmail.com").password("teste123").build();

        when(mapper.login(user)).thenReturn(null);

        User userLogged = service.login(user);

        Assertions.assertNull(userLogged);

        verify(mapper, times(1)).login(any());
    }
}
