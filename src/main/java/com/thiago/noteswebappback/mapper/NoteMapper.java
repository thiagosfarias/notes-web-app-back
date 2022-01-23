package com.thiago.noteswebappback.mapper;

import com.thiago.noteswebappback.mapper.typeHandler.UUIDTypeHandler;
import com.thiago.noteswebappback.models.Note;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Mapper
@Repository
public interface NoteMapper {
    @Select("       select * from notes.notes as n\n" +
            "        where n.user_id = #{uuid}")
    @Results(value = {
            @Result(column = "id", property = "uuid", jdbcType = JdbcType.OTHER, typeHandler = UUIDTypeHandler.class),
            @Result(column = "title", property = "title"),
            @Result(property = "text", column = "text"),
            @Result(column = "created", property = "created"),
            @Result(column = "updated", property = "updated"),
            @Result(column = "user_id", property = "user")
    })
    List<Note> findAll(@Param("uuid") UUID uuid);

    @Insert("insert into notes.notes (title, text, created, updated, id, user_id)\n" +
            "values (#{note.title}, #{note.text}, " +
            "#{note.created}, #{note.updated}, #{note.uuid}, #{note.user})")
    void insert(@Param("note")Note note);

    @Update("update notes.notes set title = #{note.title}, text = #{note.text}, updated = #{note.updated} " +
            "where id = #{note.uuid}")
    void update(@Param("note") Note note);

    @Delete("delete from notes.notes where id = #{uuid}")
    void delete(@Param("uuid") UUID uuid);
}
