package com.wit.literatureinfo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {

    @Update("update user set password = #{password} where username = #{username} ")
    Integer UpdateUserPasswordByUsername(String username, String password);
}
