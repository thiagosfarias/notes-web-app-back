package com.thiago.noteswebappback.services;

import com.thiago.noteswebappback.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User register(User user);
    User login(User user);
}
