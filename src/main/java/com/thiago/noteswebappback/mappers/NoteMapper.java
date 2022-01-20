package com.thiago.noteswebappback.mappers;

import com.thiago.noteswebappback.models.Note;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NoteMapper {
    List<Note> findAll(@Param("uuid") UUID uuid);
    void insert(@Param("note")Note note);
    void delete(@Param("uuid") UUID uuid);
}
