package com.wit.literatureinfo.controller;

import com.wit.literatureinfo.domain.Tag;
import com.wit.literatureinfo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


@RestController
public class TagRestController {
    @Autowired
    private TagService tagService;

    public static final Logger LOGGER = LogManager.getLogger(TagRestController.class);

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
        return ResponseObject.returnSelectObject(tags, "tag");
    }

    /**
     * 修改 tag
     * @param id        paper 的 id
     * @param oldTag    需要修改的旧 tag
     * @param newTag    修改后的新 tag
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST,
            params = {"id", "oldTag", "newTag"})
    public Object updateTagById(double id, String oldTag, String newTag) {
        Integer affectedRows = 0;
        // 出现异常需要事务回滚
        try{
            affectedRows = tagService.updateTagById(id, oldTag, newTag);
        }catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("tag修改失败", e);
        }
        return ResponseObject.returnUpdateObject(affectedRows,"affectedTagRows");
    }

    /**
     * 删除某个 tag
     * @param id    paper 的 id
     * @param tag
     * @return
     */
    @RequestMapping(value = "/api/delete",
            method = RequestMethod.POST,
            params = {"id", "tag"})
    public Object deleteTagById(double id, String tag) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnDeleteObject(affectedRows,"affectedTagRows");
    }

    /**
     * 增加 tag
     * @param id    paper 的 id
     * @param tag
     * @return
     */
    @RequestMapping(value = "/api/add",
            method = RequestMethod.POST,
            params = {"id", "tag"})
    public Object addTagById(double id, String tag) {
        Integer affectedRows = 0;
        // TODO: 2021/4/6

        return ResponseObject.returnAddObject(affectedRows,"affectedTagRows");
    }

}
