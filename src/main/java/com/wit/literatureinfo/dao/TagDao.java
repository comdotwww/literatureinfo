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

    /**
     * 查找 tag
     * @param limitStart
     * @param limitEnd
     * @return
     */
    @Select("select `tag_name` from (   " +
            "select `tag_name`, count(`tag_name`) as `num`  from  `paper_tag` group by `tag_name`    " +
            ") as t   " +
            "order by t.num DESC limit #{limitStart},#{limitEnd}  ")
    @ResultMap(value = "tagMap")
    Tag[] selectTagByNum(@Param("limitStart") Integer limitStart, @Param("limitEnd") Integer limitEnd);

    /**
     * 使用 paper_id 从 paper_tag 获取 author_name ，一般不少于 1 个
     * @param id paper 的 id
     * @return
     */
    @Select("SELECT `tag_name` FROM `paper_tag` WHERE `paper_id` = #{id}")
    @ResultMap(value = "tagMap")
    Tag[] selectTagById(@Param("id") double id);



    /**
     * 使用 paper_id 从 paper_tag 修改 tag ，返回值是此次修改影响了多少行
     * @param id paper 的 id
     * @param oldTag    需要修改的旧 tag
     * @param newTag    修改后的新 tag
     * @return
     */
    @Update("UPDATE paper_tag " +
            "SET `tag_name` = #{newTag} " +
            "WHERE `paper_id` = #{id} and `tag_name` = #{oldTag}")
    Integer updateTagById(@Param("id") double id ,
                          @Param("oldTag") String oldTag,
                          @Param("newTag") String newTag);

    /**
     * 根据 id 和 旧 tag 删除
     * @param id
     * @param tag
     * @return
     */
    @Delete("delete from `paper_tag` where `paper_id` = #{id} and `tag_name` = #{tag} ")
    Integer deleteTagById(@Param("id") double id, @Param("tag") String tag);

    /**
     * 根据 id 增加新 tag
     * @param id
     * @param tag
     * @return
     */
    @Insert("insert into paper_tag (paper_id, tag_name) values (#{id}, #{tag} ) ")
    Integer addTagById(@Param("id") double id,@Param("tag") String tag);


}
