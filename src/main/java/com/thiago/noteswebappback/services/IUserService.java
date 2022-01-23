package com.thiago.noteswebappback.services;

import com.thiago.noteswebappback.exceptions.ApiException;
import com.thiago.noteswebappback.exceptions.UserException;
import com.thiago.noteswebappback.mapper.UserMapper;
import com.thiago.noteswebappback.models.User;
import com.thiago.noteswebappback.models.enums.Errors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IUserService implements UserService{
    private final UserMapper mapper;
    private final EncryptService service;

    @Override
    public User register(User user) throws NoSuchAlgorithmException {
        try{
            if(!Boolean.TRUE.equals(verifyEmail(user.getEmail()))){
                return null;
            }

            User newUser = User.builder()
                    .uuid(UUID.randomUUID())
                    .email(user.getEmail())
                    .name(user.getName())
                    .password(service.encode(user.getPassword()))
                    .build();

            mapper.insert(newUser);

            return newUser;
        } catch (ApiException apiException){
            throw new UserException(Errors.DATABASE_ERROR.getTitle());
        }
    }

    public Boolean verifyEmail(String email){
        return Objects.isNull(mapper.verifyEmail(email));
    }

    @Override
    public User login(User user) {
        return mapper.login(user);
    }


}
