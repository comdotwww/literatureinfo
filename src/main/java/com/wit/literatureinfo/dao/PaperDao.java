package com.wit.literatureinfo.dao;

import com.wit.literatureinfo.domain.Paper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface PaperDao {

    @Select({"select paper_id, title, abstract_content, pdf_url, date from paper"})
    @Results(id = "paperMap", value = {
            @Result(property = "id", column = "paper_id", jdbcType = JdbcType.INTEGER),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR),
            @Result(property = "abstract_content", column = "abstract_content"),
            @Result(property = "pdf_url", column = "pdf_url", jdbcType = JdbcType.VARCHAR),
            @Result(property = "date", column = "date", jdbcType = JdbcType.DATE)
    })
    List<Paper> selectAll();

    @Select("select `paper_id` from `paper` order by `paper_id` DESC limit #{limitStart},#{limitEnd} ")
    Double[] selectPaperByNum(Integer limitStart, Integer limitEnd);

    /**
     * 使用 paper_id 从 paper 获取 title, abstract_content, pdf_url, date.一般不多于 1 个
     * @param id    paper 的 id
     * @return
     */
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

    /**
     * 由 title 从 paper 查询 paper , 一般有 0 和 多个
     * @param title 模糊
     * @param limitStart    结果分页始
     * @param limitEnd  结果分页末
     * @return
     */
    @Select("<script> " +
            "select paper_id from (" +
            "   select paper_id, date " +
            "   from paper " +
            "   <where> " +
            "       <choose>" +
            "           <when test='title != null and title != &quot;&quot; and limitStart >= 0 and limitEnd > 0' > " +
            "               title like CONCAT('%', #{title}, '%') " +
            "                   limit #{limitStart},#{limitEnd} " +
            "           </when>" +
            "           <otherwise>                                                 " +
            "               and 1 = 0                                               " +
            "           </otherwise>                                                " +
            "       </choose> " +
            "   </where> " +
            ") t " +
            "order by t.date desc" +
            "</script>")
    Double[] selectPaperByTitle(@Param("title") String title,
                               @Param("limitStart") Integer limitStart,
                               @Param("limitEnd") Integer limitEnd);

    /**
     * 由 author 从 paper_author 查询 paper_id , 一般有 0 和 多个
     * @param author    模糊
     * @param limitStart    结果分页始
     * @param limitEnd  结果分页末
     * @return
     */
    @Select("select * from " +
                    "( select paper_id from paper_author " +
                    "where author_name LIKE UPPER(CONCAT('%',#{author},'%')) " +
                    "OR author_name LIKE LOWER(CONCAT('%',#{author},'%')) " +
                    "ORDER BY paper_id  " +
                    "limit #{limitStart},#{limitEnd} ) t " +
            "order by paper_id desc")
    Double[] selectPaperByAuthor(@Param("author") String author,
                                @Param("limitStart") Integer limitStart,
                                @Param("limitEnd") Integer limitEnd);

    /**
     * 由 tag 和 date 从 paper_author 查询 paper_id , 一般有 0 和 多个
     * @param tag 精确
     * @param date 精确
     * @param limitStart 结果分页始
     * @param limitEnd 结果分页末
     * @return
     */
    @Select("select * from ( " +
            "   select paper_id " +
            "   from `paper` where `paper`.`paper_id` in " +
            "   ( " +
            "       select `paper_tag`.`paper_id` from `paper_tag` where `tag_name` = #{tag} ) " +
            "       and `paper`.`date` = #{date} limit #{limitStart},#{limitEnd}" +
            "   ) t " +
            "order by t.paper_id DESC" )
    Double[] selectPaperByTagDate(@Param("tag") String tag,
                                 @Param("date") String date,
                                 @Param("limitStart") Integer limitStart,
                                 @Param("limitEnd") Integer limitEnd);

    /**
     * 由 tag 和 title 从 paper_author 查询 paper , 一般有 0 和 多个
     * @param tag   精确
     * @param title     模糊
     * @param limitStart    结果分页始
     * @param limitEnd  结果分页末
     * @return
     */
    @Select("select paper_id from " +
            "(" +
            "   select paper_id, date from paper where title like CONCAT('%',#{title},'%') and paper_id in  " +
            "   ( " +
            "       select  paper_id from paper_tag where tag_name = #{tag} " +
            "   ) " +
            ")t " +
            "order by t.date DESC limit #{limitStart},#{limitEnd} ")
    Double[] selectPaperByTagTitle(@Param("tag") String tag, @Param("title") String title, @Param("limitStart") Integer limitStart, @Param("limitEnd") Integer limitEnd);

    @Select("select * from " +
            "( " +
            "   select paper_id " +
            "   from paper_tag " +
            "   where tag_name = #{tag} " +
            ")t " +
            "order by t.paper_id DESC limit #{limitStart},#{limitEnd} ")
    Double[] selectPaperByTag(@Param("tag") String tag, @Param("limitStart") Integer limitStart, @Param("limitEnd") Integer limitEnd);

    /**
     * 修改 paper 标题
     * @param id
     * @param title
     * @return
     */
    @Update("UPDATE `paper` SET `title` = #{title} WHERE `paper_id` = #{id} ")
    Integer updateTitleById(@Param("id") double id, @Param("title") String title);

    /**
     * 修改 paper 的 abstract
     * @param id
     * @param newAbstract
     * @return
     */
    @Update("UPDATE `paper` SET `abstract_content` = #{newAbstract} WHERE `paper_id` = #{id} ")
    Integer updateAbstractById(@Param("id") double id, @Param("newAbstract") String newAbstract);

    /**
     * 修改 paper 的 PDF 的链接
     * @param id
     * @param newUrl
     * @return
     */
    @Update("UPDATE `paper` SET `pdf_url` = #{newUrl} WHERE `paper_id` = #{id} ")
    Integer updateUrlById(@Param("id") double id, @Param("newUrl") String newUrl);

    /**
     * 修改 paper  的 日期
     * @param id
     * @param newDate
     * @return
     */
    @Update("UPDATE `paper` SET `date` = #{newDate} WHERE `paper_id` = #{id} ")
    Integer updateDateById(@Param("id") double id, @Param("newDate") String newDate);

    /**
     * 删除 paper
     * @param id
     * @return
     */
    @Delete("delete from `paper` where `paper_id` = #{id} ")
    Integer deletePaperById(@Param("id") double id);

    /**
     * 添加 paper
     * @param id
     * @param title
     * @param abstractContent
     * @param url
     * @param date
     * @return
     */
    @Insert("insert into paper (paper_id, title, abstract_content, pdf_url, date) " +
            "values (#{id}, #{title}, #{abstractContent}, #{url}, #{date}) ")
    Integer addPaperById(@Param("id") double id, @Param("title") String title, @Param("abstractContent") String abstractContent, @Param("url") String url, @Param("date") String date);


}
