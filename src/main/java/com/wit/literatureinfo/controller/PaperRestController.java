package com.wit.literatureinfo.controller;

import com.wit.literatureinfo.domain.Author;
import com.wit.literatureinfo.domain.Paper;
import com.wit.literatureinfo.domain.Tag;
import com.wit.literatureinfo.service.AuthorService;
import com.wit.literatureinfo.service.PaperService;
import com.wit.literatureinfo.service.TagService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaperRestController {
    @Autowired
    private PaperService paperService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private TagService tagService;


    public static final Logger LOGGER = LogManager.getLogger(TagRestController.class);

    /**
     * 使用 paper 的 id 精确查找 paper
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/paper", method = RequestMethod.POST, params = {"id"})
    public Object selectPaperById(double id) {
        Paper paper = paperService.selectPaperById(id);
        Author[] authors = authorService.selectAuthorById(id);
        Tag[] tags = tagService.selectTagById(id);
        return ResponseObject.returnSelectObject(paper, authors, tags);
    }


    /**
     * 使用 tag 精确查找 paper
     * @param tag     标题
     * @param limitStart    结果分页起始
     * @param limitEnd
     * @return
     */
    @RequestMapping(value = "/api/paper", method = RequestMethod.POST, params = {"tag", "limitStart", "limitEnd"})
    public Object selectPaperByTag(String tag, Integer limitStart, Integer limitEnd) {
        Double[] papers = paperService.selectPaperByTag(tag, limitStart, limitEnd);
        if (papers.length == 0) {
            papers = null;
        }
        return ResponseObject.returnSelectObject(papers, "id");
    }

    /**
     * 使用 title 模糊查找 paper 的 id
     * @param title     标题
     * @param limitStart    结果分页起始
     * @param limitEnd
     * @return
     */
    @RequestMapping(value = "/api/paper", method = RequestMethod.POST, params = {"title", "limitStart", "limitEnd"})
    public Object selectPaperByTitle(String title, Integer limitStart, Integer limitEnd) {
        Paper[] papers = paperService.selectPaperByTitle(title, limitStart, limitEnd);
        if (papers.length == 0) {
            papers = null;
        }
        return ResponseObject.returnSelectObject(papers, "paper");
    }

    /**
     * 使用 author 模糊查找 paper 的 id
     * @param author        作者
     * @param limitStart    结果分页起始
     * @param limitEnd
     * @return
     */
    @RequestMapping(value = "/api/paper", method = RequestMethod.POST, params = {"author", "limitStart", "limitEnd"})
    public Object selectPaperByAuthor(String author, Integer limitStart, Integer limitEnd) {
        Double[] papers = paperService.selectPaperByAuthor(author, limitStart, limitEnd);
        if (papers.length == 0) {
            papers = null;
        }
        return ResponseObject.returnSelectObject(papers, "id");
    }

    /**
     * 使用 tag, date 查找 paper
     * @param tag
     * @param date
     * @param limitStart    结果分页起始
     * @param limitEnd
     * @return
     */
    @RequestMapping(value = "/api/paper", method = RequestMethod.POST, params = {"tag", "date", "limitStart", "limitEnd"})
    public Object selectPaperByTagDate(String tag, String date, Integer limitStart, Integer limitEnd) {
        // 数据库里 date 格式是 年月日 时分秒 2021-04-01 00:00:00
        // 前端传来的数据格式是 年月日 2021-04-01
        date = date + " 00:00:00";
        Paper[] papers = paperService.selectPaperByTagDate(tag, date, limitStart, limitEnd);
        if (papers.length == 0) {
            papers = null;
        }
        return ResponseObject.returnSelectObject(papers, "paper");
    }

    /**
     * 使用 tag 和 title 模糊查找 paper ，tag 是精确的, title 模糊
     * @param tag
     * @param title
     * @param limitStart    结果分页起始
     * @param limitEnd
     * @return
     */
    @RequestMapping(value = "/api/paper", method = RequestMethod.POST, params = {"tag", "title", "limitStart", "limitEnd"})
    public Object selectPaperByTagTitle(String tag, String title, Integer limitStart, Integer limitEnd) {
        Paper[] papers = paperService.selectPaperByTagTitle(tag, title, limitStart, limitEnd);
        if (papers.length == 0) {
            papers = null;
        }
        return ResponseObject.returnSelectObject(papers, "paper");
    }

    /**
     * 修改 paper title
     * @param id        paper 的 id
     * @param title    修改后的新 title
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST,
            params = {"id", "title"})
    public Object updateTitleById(double id, String title) {
        Integer affectedRows = 0;
        // 出现异常需要事务回滚
        try{
            affectedRows = paperService.updateTitleById(id, title);
        }catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("title 修改失败", e);
        }

        return ResponseObject.returnUpdateObject(affectedRows,"affectedTitleRows");
    }

    /**
     * 修改 paper abstract_content
     * @param id        paper 的 id
     * @param newAbstract    修改后的新 abstract
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST,
            params = {"id", "newAbstract"})
    public Object updateAbstractById(double id, String newAbstract) {
        Integer affectedRows = 0;
        // 出现异常需要事务回滚
        try{
            affectedRows = paperService.updateAbstractById(id, newAbstract);
        }catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("abstract 修改失败", e);
        }

        return ResponseObject.returnUpdateObject(affectedRows,"affectedAbstractRows");
    }

    /**
     * 修改 paper pdf_url
     * @param id        paper 的 id
     * @param newUrl    修改后的新 url
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST,
            params = {"id", "newUrl"})
    public Object updateUrlById(double id, String newUrl) {
        Integer affectedRows = 0;
        // 出现异常需要事务回滚
        try{
            affectedRows = paperService.updateUrlById(id, newUrl);
        }catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("pdf_url 修改失败", e);
        }

        return ResponseObject.returnUpdateObject(affectedRows,"affectedUrlRows");
    }

    /**
     * 修改 paper Date
     * @param id        paper 的 id
     * @param newDate    修改后的新 日期
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST,
            params = {"id", "newDate"})
    public Object updateDateById(double id, String newDate) {
        Integer affectedRows = 0;
        // 出现异常需要事务回滚
        try{
            affectedRows = paperService.updateDateById(id, newDate);
        }catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("date 修改失败", e);
        }

        return ResponseObject.returnUpdateObject(affectedRows,"affectedDateRows");
    }

    /**
     * 删除某个 paper
     * @param id    paper 的 id
     * @return
     */
    @RequestMapping(value = "/api/delete",
            method = RequestMethod.POST,
            params = {"id"})
    public Object deletePaperById(double id) {
        Integer affectedRows = 0;
        // 出现异常需要事务回滚
        try{
            // delete tag
            Tag[] tags = tagService.selectTagById(id);
            if (tags.length != 0) {
                for (Tag tag:tags) {
                    affectedRows = affectedRows + tagService.deleteTagById(id, tag.getName());
                }
            }

            // delete author
            Author[] authors = authorService.selectAuthorById(id);
            if (authors.length != 0) {
                for (Author author:authors) {
                    affectedRows = affectedRows + authorService.deleteAuthorById(id, author.getName());
                }
            }

            // delete paper
            affectedRows = affectedRows + paperService.deletePaperById(id);

        }catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("paper 删除失败", e);
        }

        return ResponseObject.returnDeleteObject(affectedRows,"affectedPaperRows");
    }

    /**
     * 增加 paper
     * @param id    id
     * @param title     标题
     * @param author    作者
     * @param tag       标签
     * @param abstractContent   摘要
     * @param url   pdf 链接
     * @param date  日期
     * @return
     */
    @RequestMapping(value = "/api/add",
            method = RequestMethod.POST,
            params = {"id", "title", "author", "tag", "abstractContent", "url", "date"})
    public Object addPaperById(double id, String title, String author, String tag, String abstractContent, String url, String date) {
        Integer affectedRows = 0;
        // 出现异常需要事务回滚
        try{
            // 增加 id 下 paper
            // 测试 paper 是否有重复的
            Paper paper = paperService.selectPaperById(id);
            if (paper != null) {
                return ResponseObject.returnAddObject(affectedRows,"affectedPaperRows");
            }
            affectedRows = affectedRows + paperService.addPaperById(id, title, abstractContent, url, date);

            // 增加 id 下 paper_tag
            affectedRows = affectedRows + tagService.addTagById(id, tag);

            // 增加 id 下 paper_author
            affectedRows = affectedRows + authorService.addAuthorById(id, author);

        }catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("tag 添加失败", e);
        }

        return ResponseObject.returnAddObject(affectedRows,"affectedPaperRows");
    }

}
