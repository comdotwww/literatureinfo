package com.wit.literatureinfo.dao;

import com.wit.literatureinfo.domain.Tag;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface TagDao {

    @Select({"select record_id, tag_name from paper_tag"})
    @Results(id = "tagMap", value = {
            @Result(property = "name", column = "tag_name", jdbcType = JdbcType.VARCHAR)
    })
    List<Tag> selectAll();

    /** 使用 paper_id 从 paper_tag 获取 author_name ，一般不少于 1 个 **/
    @Select("SELECT `tag_name` FROM `paper_tag` WHERE `paper_id` = #{id}")
    @ResultMap(value = "tagMap")
    Tag[] selectTagById(@Param("id") double id);
}
