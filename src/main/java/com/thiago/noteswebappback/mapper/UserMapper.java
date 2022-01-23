package com.thiago.noteswebappback.mapper;

import com.thiago.noteswebappback.mapper.typeHandler.UUIDTypeHandler;
import com.thiago.noteswebappback.models.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into users.user (email, name, password, id) " +
            "values (#{user.email},#{user.name},#{user.password}, #{user.uuid})")
    void insert(@Param("user")User user);

    @Select("select * from users.user where email like #{user.email} " +
            "and password like #{user.password}")
    @Results(value = {
            @Result(column = "id", property = "uuid", jdbcType = JdbcType.OTHER, typeHandler = UUIDTypeHandler.class),
            @Result(column = "name", property = "name"),
            @Result(property = "email", column = "email"),
            @Result(column = "password", property = "password")
    })
    User login(@Param("user")User user);

    @Select("select users.user.email from users.user where email like #{email}")
    String verifyEmail(@Param("email")String email);
}
