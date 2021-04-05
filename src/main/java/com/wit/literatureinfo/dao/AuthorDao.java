package com.wit.literatureinfo.dao;

import com.wit.literatureinfo.domain.Author;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface AuthorDao {

    @Select({"select id, name from author"})
    @Results(id = "authorMap", value = {
            @Result(property = "name", column = "author_name", jdbcType = JdbcType.VARCHAR)
    })
    List<Author> selectAll();

    /** 使用 paper_id 从 paper_author 获取 author_name ，一般不少于 1 个 **/
    @Select("SELECT `author_name` FROM `paper_author` WHERE `paper_id` = #{id}")
    @ResultMap(value = "authorMap")
    Author[] selectAuthorById(@Param("id") double id);

}
