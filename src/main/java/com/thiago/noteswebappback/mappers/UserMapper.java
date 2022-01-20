package com.thiago.noteswebappback.mappers;

import com.thiago.noteswebappback.models.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User register(@Param("user")User user);
    User login(@Param("user")User user);
}
