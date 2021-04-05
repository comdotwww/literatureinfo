package com.wit.literatureinfo.service.impl;

import com.wit.literatureinfo.dao.TagDao;
import com.wit.literatureinfo.domain.Tag;
import com.wit.literatureinfo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public Tag[] selectTagById(double id) {
        return tagDao.selectTagById(id);
    }

    @Override
    public Integer updateTagById(double id, String oldTag, String newTag) {
        return tagDao.updateTagById(id, oldTag, newTag);
    }


}
