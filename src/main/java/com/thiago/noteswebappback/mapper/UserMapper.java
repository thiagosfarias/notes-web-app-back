package com.thiago.noteswebappback.mapper;

import com.thiago.noteswebappback.models.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

@Mapper
public interface UserMapper {
    User register(@Param("user")User user);
    User login(@Param("user")User user);
    User findUser(@Param("uuid")UUID uuid);
    String verifyEmail(@Param("email")String email);
}
