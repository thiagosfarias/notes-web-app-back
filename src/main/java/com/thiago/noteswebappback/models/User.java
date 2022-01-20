package com.thiago.noteswebappback.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class User {
    private UUID uuid;
    private String name;
    private String email;
    private String password;
}
