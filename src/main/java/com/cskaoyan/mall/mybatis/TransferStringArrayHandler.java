package com.cskaoyan.mall.mybatis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(String[].class)
@MappedJdbcTypes({JdbcType.VARCHAR})
public class TransferStringArrayHandler implements TypeHandler<String[]> {

    //新建一个ObjectMapper对象，后边用它来进行Json格式字符串和字符串数组之间的转换
    ObjectMapper objectMapper = new ObjectMapper();

    //利用ObjectMapper对象将Json格式字符串转换为字符串数组
    private String[] parseString2StringArray(String value) {

        String[] strings = new String[0];
        if (value == null){
            return strings;
        }
        try {
            strings = objectMapper.readValue(value, String[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    //由javabean数据类型转换为jdbc数据类型
    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, String[] strings, JdbcType jdbcType)
            throws SQLException {
        try {
            //利用ObjectMapper对象将字符串数组转换为Json格式字符串
            String jsonArray = objectMapper.writeValueAsString(strings);
            preparedStatement.setString(index,jsonArray);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    //由jdbc数据类型转换为javabean数据类型
    @Override
    public String[] getResult(ResultSet resultSet, String parameterName) throws SQLException {
        String value = resultSet.getString(parameterName);
        return parseString2StringArray(value);
    }

    //由jdbc数据类型转换为javabean数据类型
    @Override
    public String[] getResult(ResultSet resultSet, int index) throws SQLException {
        String value = resultSet.getString(index);
        return parseString2StringArray(value);
    }
    //由jdbc数据类型转换为javabean数据类型
    @Override
    public String[] getResult(CallableStatement callableStatement, int index) throws SQLException {
        String value = callableStatement.getString(index);
        return parseString2StringArray(value);
    }


}
