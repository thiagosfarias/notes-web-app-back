package com.thiago.noteswebappback.mapper;

import com.thiago.noteswebappback.models.Note;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
public interface NoteMapper {
    List<Note> findAll(@Param("uuid") UUID uuid);
    void insert(@Param("note")Note note);
    void delete(@Param("uuid") UUID uuid);
}
