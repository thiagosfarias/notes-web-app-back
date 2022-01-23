package com.thiago.noteswebappback.controllers;

import com.thiago.noteswebappback.models.Note;
import com.thiago.noteswebappback.services.NotesService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/notes")
@RequiredArgsConstructor
public class NotesController {
    private final NotesService service;

    @GetMapping
    public ResponseEntity<List<Note>> findAll(@RequestParam(value = "uuid")UUID uuid){
        return ResponseEntity.ok().body(service.findAll(uuid));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Note note){
            Note newNote = Note.builder()
                    .title(note.getTitle())
                    .text(note.getText())
                    .created(LocalDateTime.now())
                    .updated(LocalDateTime.now())
                    .uuid(UUID.randomUUID())
                    .user(note.getUser())
                    .build();

            service.create(newNote);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody Note note){
        Note newNote = Note.builder()
                .uuid(note.getUuid())
                .title(note.getTitle())
                .text(note.getText())
                .updated(LocalDateTime.now())
                .build();

        service.update(newNote);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestParam(value = "uuid") UUID uuid){
        service.delete(uuid);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
