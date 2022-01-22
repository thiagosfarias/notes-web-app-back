package com.thiago.noteswebappback.services;

import com.thiago.noteswebappback.models.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface NotesService {
    List<Note> findAll(UUID uuid);
    void newNote(Note note);
    void deleteNote(UUID uuid);
}
