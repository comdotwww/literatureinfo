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
        return ResponseObject.returnObject(authors, "author");
    }
}
