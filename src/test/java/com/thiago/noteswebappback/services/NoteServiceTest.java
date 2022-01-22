package com.thiago.noteswebappback.services;


import com.thiago.noteswebappback.mapper.NoteMapper;
import com.thiago.noteswebappback.models.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {
    @Mock
    private NoteMapper mapper;
    @InjectMocks
    private INotesService service;

    @Test
    public void mustReturnAllNotesFromUserWithSucess(){
        UUID uuid = UUID.randomUUID();

        when(mapper.findAll(uuid)).thenReturn(Collections.singletonList(new Note()));

        List<Note> notes = service.findAll(uuid);

        assertNotNull(notes);

        verify(mapper, times(1)).findAll(any());
    }


    @Test
    public void mustSaveANewNoteWithSucess(){
        Note note = Note.builder().uuid(UUID.randomUUID())
                        .created(LocalDateTime.now())
                        .updated(LocalDateTime.now())
                        .text("Whatever you want to write here")
                        .title("New Note Test")
                        .build();

        service.newNote(note);

        verify(mapper, times(1)).insert(any());
    }

    @Test
    public void mustDeleteANoteWithSucess(){
        service.deleteNote(UUID.randomUUID());

        verify(mapper, times(1)).delete(any());
    }
}
