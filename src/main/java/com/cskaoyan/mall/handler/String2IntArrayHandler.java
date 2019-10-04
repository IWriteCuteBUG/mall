package com.cskaoyan.mall.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class String2IntArrayHandler implements TypeHandler<int[]> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, int[] ints, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public int[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return string2IntArray(string);
    }

    private int[] string2IntArray(String string) {
        ObjectMapper objectMapper = new ObjectMapper();
        int[] ints = null;
        try {
            ints = objectMapper.readValue(string, int[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ints;
    }

    @Override
    public int[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return string2IntArray(string);
    }

    @Override
    public int[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return string2IntArray(string);
    }
}
