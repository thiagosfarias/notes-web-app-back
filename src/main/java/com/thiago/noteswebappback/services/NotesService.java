package com.thiago.noteswebappback.services;

import com.thiago.noteswebappback.models.Note;
import java.util.List;
import java.util.UUID;


public interface NotesService {
    List<Note> findAll(UUID uuid);
    void create(Note note);
    void update(Note note);
    void delete(UUID uuid);
}
