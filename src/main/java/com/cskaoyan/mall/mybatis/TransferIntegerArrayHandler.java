package com.cskaoyan.mall.mybatis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Integer[].class)
public class TransferIntegerArrayHandler implements TypeHandler<Integer[]> {
    ObjectMapper objectMapper = new ObjectMapper();

    /*插入数据 由javabean转换为数据库接收的类型*/
    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, Integer[] integers, JdbcType jdbcType) throws SQLException {
        String s=null;
        try {
             s= objectMapper.writeValueAsString(integers);
            preparedStatement.setString(index,s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    //由数据中查询出的结果转换成javabean中的类型
    @Override
    public Integer[] getResult(ResultSet resultSet, String s) throws SQLException {
        String value = resultSet.getString(s);
        return parseString2StringArray(value);
    }

    private Integer[] parseString2StringArray(String value) {

        Integer[] integers = new Integer[0];
        if (value == null){
            return integers;
        }
        try {
            integers= objectMapper.readValue(value, Integer[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integers;
    }

    @Override
    public Integer[] getResult(ResultSet resultSet, int index) throws SQLException {
        String value = resultSet.getString(index);
        return parseString2StringArray(value);
    }

    @Override
    public Integer[] getResult(CallableStatement callableStatement, int index) throws SQLException {
        String value = callableStatement.getString(index);
        return parseString2StringArray(value);
    }
}
