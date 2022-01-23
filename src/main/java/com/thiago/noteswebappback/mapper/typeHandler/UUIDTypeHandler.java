package com.thiago.noteswebappback.mapper.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@MappedTypes(UUID.class)
public class UUIDTypeHandler extends BaseTypeHandler<UUID> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UUID uuid, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(i, uuid);
    }

    @Override
    public UUID getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String uuid = resultSet.getString(s);
        if (resultSet.wasNull()) {
            return null;
        }
        return UUID.fromString(uuid);
    }

    @Override
    public UUID getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String uuid = resultSet.getString(i);
        if (resultSet.wasNull()) {
            return null;
        }
        return UUID.fromString(uuid);
    }

    @Override
    public UUID getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String uuid = callableStatement.getString(i);
        if (callableStatement.wasNull()) {
            return null;
        }
        return UUID.fromString(uuid);
    }
}