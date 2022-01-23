package com.thiago.noteswebappback.services;

import com.thiago.noteswebappback.mapper.NoteMapper;
import com.thiago.noteswebappback.models.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class INotesService implements NotesService{
    private final NoteMapper mapper;

    @Override
    public List<Note> findAll(UUID uuid) {
        return mapper.findAll(uuid);
    }

    @Override
    public void create(Note note) {
        mapper.insert(note);
    }

    @Override
    public void update(Note note) {
        mapper.update(note);
    }

    @Override
    public void delete(UUID uuid) {
        mapper.delete(uuid);
    }
}
