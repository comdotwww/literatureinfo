package com.wit.literatureinfo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {

    /**
     * 修改 密码
     * @param username
     * @param password
     * @return
     */
    @Update("update user set password = #{password} where username = #{username} ")
    Integer UpdateUserPasswordByUsername(@Param("username") String username, @Param("password") String password);
}
