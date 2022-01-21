package com.thiago.noteswebappback.controllers;

import com.thiago.noteswebappback.models.Note;
import com.thiago.noteswebappback.services.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class NotesController {
    private final NotesService service;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> findAll(@RequestParam(value = "uuid")UUID uuid){
        return ResponseEntity.ok().body(service.findAll(uuid));
    }
}
