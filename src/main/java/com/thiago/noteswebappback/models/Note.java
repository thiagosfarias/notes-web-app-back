package com.thiago.noteswebappback.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private UUID uuid;
    private String text;
    private String title;
    private LocalDateTime dateTime;
    private Boolean isDeleted;

}
