package com.wit.literatureinfo.dao;

import com.wit.literatureinfo.domain.Paper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface PaperDao {

    @Select({"select paper_id, title, abstract_content, pdf_url, date from paper"})
    @Results(id = "paperMap", value = {
            @Result(property = "id", column = "paper_id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR),
            @Result(property = "abstract_content", column = "abstract_content"),
            @Result(property = "pdf_url", column = "pdf_url", jdbcType = JdbcType.VARCHAR),
            @Result(property = "date", column = "date", jdbcType = JdbcType.DATE)
    })
    List<Paper> selectAll();

    /** 使用 paper_id 从 paper 获取 title abstract_content pdf_url date，一般不多于 1 个 **/
    @Select("<script>" +
                "select `paper_id`, `title`, `abstract_content`, `pdf_url`, `date`  " +
                "from paper                                                         " +
                "<where>                                                            " +
                "   <choose>                                                        " +
                "       <when test='id != null and id != &quot;&quot;'>             " +
                "         `paper`.`paper_id` = #{id}                                " +
                "       </when>                                                     " +
                "       <otherwise>                                                 " +
                "           and 1 = 0                                               " +
                "       </otherwise>                                                " +
                "   </choose>                                                       " +
                "</where>                                                           " +
            "</script>")
    @ResultMap(value = "paperMap")
    Paper selectPaperById(@Param("id") double id);

    /** 由 title 从 paper 查询 paper_id , 一般有 0 和 多个 **/
    @Select("select paper_id, title, abstract_content, pdf_url, date from paper where title like CONCAT('%', #{title}, '%') limit #{limitStart},#{limitEnd}")
    @ResultMap(value = "paperMap")
    Paper[] selectPaperByTitle(@Param("title") String title, @Param("limitStart") Integer limitStart, @Param("limitEnd") Integer limitEnd);
}
