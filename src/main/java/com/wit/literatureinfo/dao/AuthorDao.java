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

    @Select("select `author_name` from (  " +
            "select `author_name`, count(`author_name`) as `num`  from  `paper_author` group by `author_name`   " +
            ") as t " +
            "order by t.num DESC limit #{limitStart},#{limitEnd} ")
    @ResultMap(value = "authorMap")
    Author[] selectAuthorByNum(@Param("limitStart") Integer limitStart, @Param("limitEnd") Integer limitEnd);

    /**
     * 使用 paper_id 从 paper_author 获取 author_name ，一般不少于 1 个
     * @param id  paper 的 id
     * @return
     */
    @Select("SELECT `author_name` FROM `paper_author` WHERE `paper_id` = #{id}")
    @ResultMap(value = "authorMap")
    Author[] selectAuthorById(@Param("id") double id);


    /**
     * 修改 author
     * @param id
     * @param oldAuthor
     * @param newAuthor
     * @return
     */
    @Update("UPDATE paper_author " +
            "SET `author_name` = #{newAuthor} " +
            "WHERE `paper_id` = #{id} and `author_name` = #{oldAuthor}")
    Integer updateAuthorById(@Param("id") double id, @Param("oldAuthor") String oldAuthor, @Param("newAuthor") String newAuthor);

    /**
     * 删除 author
     * @param id
     * @param author
     * @return
     */
    @Delete("delete from paper_author where paper_id = #{id} and author_name = #{author} ")
    Integer deleteAuthorById(@Param("id") double id, @Param("author") String author);

    /**
     * 添加 author
     * @param id
     * @param author
     * @return
     */
    @Insert("insert into paper_author (paper_id, author_name) values (#{id}, #{author}) ")
    Integer addAuthorById(@Param("id") double id, @Param("author") String author);


}
