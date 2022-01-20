package com.thiago.noteswebappback.services;

import com.thiago.noteswebappback.mappers.NoteMapper;
import com.thiago.noteswebappback.models.Note;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class INotesService implements NotesService{
    private NoteMapper mapper;

    @Override
    public List<Note> findAll(UUID uuid) {
        return mapper.findAll(uuid);
    }

    @Override
    public void newNote(Note note) {
        mapper.insert(note);
    }

    @Override
    public void deleteNote(UUID uuid) {
        mapper.delete(uuid);
    }
}
