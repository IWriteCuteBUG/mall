//package com.cskaoyan.mall.mybatis;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.MappedTypes;
//import org.apache.ibatis.type.TypeHandler;
//
//import java.io.IOException;
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@MappedTypes(UserDetail.class)
//public class TransferUserDetailHandler implements TypeHandler<UserDetail> {
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void setParameter(PreparedStatement preparedStatement, int i, UserDetail userDetail, JdbcType jdbcType) throws SQLException {
//        String s = null;
//        try {
//            s = objectMapper.writeValueAsString(userDetail);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        preparedStatement.setString(i,s);
//    }
//
//    @Override
//    public UserDetail getResult(ResultSet resultSet, String s) throws SQLException {
//        String string = resultSet.getString(s);
//        return parseString2UserDetail(string);
//    }
//
//    private UserDetail parseString2UserDetail(String string) {
//        UserDetail userDetail = null;
//        if (string == null)
//            return userDetail;
//        try {
//            userDetail = objectMapper.readValue(string, UserDetail.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return userDetail;
//    }
//
//    @Override
//    public UserDetail getResult(ResultSet resultSet, int i) throws SQLException {
//        String string = resultSet.getString(i);
//        return parseString2UserDetail(string);
//    }
//
//    @Override
//    public UserDetail getResult(CallableStatement callableStatement, int i) throws SQLException {
//        String string = callableStatement.getString(i);
//        return parseString2UserDetail(string);
//    }
//
//    /*插入数据 由javabean转换为数据库接收的类型*/
//
//
//}
