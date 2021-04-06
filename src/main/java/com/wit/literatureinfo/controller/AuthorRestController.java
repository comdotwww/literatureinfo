package com.wit.literatureinfo.controller;

import com.wit.literatureinfo.domain.Author;
import com.wit.literatureinfo.service.AuthorService;
import com.wit.literatureinfo.service.PaperService;
import com.wit.literatureinfo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    /**
     * 使用 paper 的 id 精确查找 author name
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/author", method = RequestMethod.POST, params = "id")
    public Object selectAuthorById(double id) {
        Author[] authors = authorService.selectAuthorById(id);
        if (authors.length == 0) {
            authors = null;
        }
        return ResponseObject.returnSelectObject(authors, "author");
    }

    /**
     * 修改 author
     * @param id        paper 的 id
     * @param oldAuthor    需要修改的旧 author
     * @param newAuthor    修改后的新 author
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST,
            params = {"id", "oldAuthor", "newAuthor"})
    public Object updateAuthorById(double id, String oldAuthor, String newAuthor) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnUpdateObject(affectedRows,"affectedTagRows");
    }

    /**
     * 删除某个 author
     * @param id    paper 的 id
     * @param author    作者
     * @return
     */
    @RequestMapping(value = "/api/delete",
            method = RequestMethod.POST,
            params = {"id", "author"})
    public Object deleteAuthorById(double id, String author) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnDeleteObject(affectedRows,"affectedTagRows");
    }

    /**
     * 增加 author
     * @param id    paper 的 id
     * @param author    作者
     * @return
     */
    @RequestMapping(value = "/api/add",
            method = RequestMethod.POST,
            params = {"id", "author"})
    public Object addAuthorById(double id, String author) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnAddObject(affectedRows,"affectedTagRows");
    }

}
