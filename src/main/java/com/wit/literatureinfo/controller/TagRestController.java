package com.wit.literatureinfo.controller;

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
public class TagRestController {
    @Autowired
    private TagService tagService;

    /**
     * 使用 paper 的 id 精确查找 tag name
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/tag", method = RequestMethod.POST, params = "id")
    public Object selectTagById(double id) {
        Tag[] tags = tagService.selectTagById(id);
        if (tags.length == 0) {
            tags = null;
        }
        return ResponseObject.returnObject(tags, "tag");
    }

    /**
     * 修改 tag
     * @param id    paper 的 id
     * @param oldTag    需要修改的旧 tag
     * @param newTag    修改后的 tag
     * @return
     */
    @RequestMapping(value = "/api/edit/tag", method = RequestMethod.POST,
            params = {"id", "oldTag", "newTag"})
    public Object updateTagById(double id, String oldTag, String newTag) {
        Integer affectedRows = tagService.updateTagById(id, oldTag, newTag);
        return affectedRows;
    }
}
