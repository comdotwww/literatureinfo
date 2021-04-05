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
import org.springframework.web.bind.annotation.RequestParam;
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
        return ResponseObject.returnObject(paper, authors, tags);
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
        // TODO: 2021/4/5
        Paper[] paper = paperService.selectPaperByTitle(title, limitStart, limitEnd);

        return ResponseObject.returnObject(paper, "paper");
    }

    /**
     * 使用 author 模糊查找 的 id
     * @param author
     * @param limitStart    结果分页起始
     * @param limitEnd
     * @return
     */
    @RequestMapping(value = "/api/paper", method = RequestMethod.POST, params = {"author", "limitStart", "limitEnd"})
    public Object selectPaperByAuthor(String author, String limitStart, String limitEnd) {
        // TODO: 2021/4/5

        return author;
    }

    /**
     * 使用 tag 和 keyword 模糊查找 的 id ，tag 是精确的
     * @param tag
     * @param keyword
     * @param limitStart    结果分页起始
     * @param limitEnd
     * @return
     */
    @RequestMapping(value = "/api/paper", method = RequestMethod.POST, params = {"tag", "keyword", "limitStart", "limitEnd"})
    public Object selectPaperByTag(String tag, String keyword, String limitStart, String limitEnd) {
        // TODO: 2021/4/5

        return tag;
    }

}
