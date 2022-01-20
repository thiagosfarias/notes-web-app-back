package com.thiago.noteswebappback.services;

import com.thiago.noteswebappback.mappers.UserMapper;
import com.thiago.noteswebappback.models.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

public class IUserService implements UserService{
    private UserMapper mapper;

    @Override
    public User register(User user) {
        return User.builder().uuid(UUID.randomUUID()).build();
    }

    @Override
    public User login(User user) {
        return user;
    }
}
