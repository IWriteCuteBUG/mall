package com.cskaoyan.mall.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class String2ArrayHandler implements TypeHandler<String[]> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(strings);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        preparedStatement.setString(i,s);
    }

    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        ObjectMapper objectMapper = new ObjectMapper();
        String[] strings = null;
        try {
            strings = objectMapper.readValue(string, String[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    @Override
    public String[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return null;
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
