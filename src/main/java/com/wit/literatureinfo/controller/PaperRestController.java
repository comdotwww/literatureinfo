package com.wit.literatureinfo.controller;

import com.wit.literatureinfo.domain.Author;
import com.wit.literatureinfo.domain.Paper;
import com.wit.literatureinfo.domain.Tag;
import com.wit.literatureinfo.service.AuthorService;
import com.wit.literatureinfo.service.PaperService;
import com.wit.literatureinfo.service.TagService;
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
     * @param oldTitle    需要修改的旧 title
     * @param newTitle    修改后的新 title
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST,
            params = {"id", "oldTitle", "newTitle"})
    public Object updateTitleById(double id, String oldTitle, String newTitle) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnUpdateObject(affectedRows,"affectedTagRows");
    }

    /**
     * 修改 paper abstract_content
     * @param id        paper 的 id
     * @param oldAbstract    需要修改的旧 abstract
     * @param newAbstract    修改后的新 abstract
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST,
            params = {"id", "oldAbstract", "newAbstract"})
    public Object updateAbstractById(double id, String oldAbstract, String newAbstract) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnUpdateObject(affectedRows,"affectedTagRows");
    }

    /**
     * 修改 paper pdf_url
     * @param id        paper 的 id
     * @param oldUrl    需要修改的旧 url
     * @param newUrl    修改后的新 url
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST,
            params = {"id", "oldUrl", "newUrl"})
    public Object updateUrlById(double id, String oldUrl, String newUrl) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnUpdateObject(affectedRows,"affectedTagRows");
    }

    /**
     * 修改 paper Date
     * @param id        paper 的 id
     * @param oldDate    需要修改的旧 date
     * @param newDate    修改后的新 date
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST,
            params = {"id", "oldDate", "newDate"})
    public Object updateDateById(double id, String oldDate, String newDate) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnUpdateObject(affectedRows,"affectedTagRows");
    }

    /**
     * 删除某个 paper
     * @param id    paper 的 id
     * @return
     */
    @RequestMapping(value = "/api/delete",
            method = RequestMethod.POST,
            params = {"id"})
    public Object deleteTagById(double id) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnDeleteObject(affectedRows,"affectedTagRows");
    }

    /**
     * 增加 paper
     * @param id    paper 的 id
     * @param tag
     * @return
     */
    @RequestMapping(value = "/api/add",
            method = RequestMethod.POST,
            params = {"id", "title", "author", "tag", "abstractContent", "url", "date"})
    public Object addTagById(double id, String title, String author, String tag, String abstractContent, String url, String date) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnAddObject(affectedRows,"affectedTagRows");
    }

}
