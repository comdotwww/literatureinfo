package com.wit.literatureinfo.service.impl;

import com.wit.literatureinfo.dao.TagDao;
import com.wit.literatureinfo.domain.Tag;
import com.wit.literatureinfo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public Tag[] selectTagById(double id) {
        return tagDao.selectTagById(id);
    }

    /**
     * 设置出现异常回滚, 默认情况下，spring 会对 unchecked 异常进行事务回滚；如果是 checked 异常则不回滚
     * Java 里面将派生于 Error 或者 RuntimeException （比如空指针，1/0）的异常称为unchecked异常，
     * 其他继承自 java.lang.Exception 的异常统称为 Checked Exception，如 IOException、TimeoutException 等
     * @param id
     * @param oldTag
     * @param newTag
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateTagById(double id, String oldTag, String newTag) {
        return tagDao.updateTagById(id, oldTag, newTag);
    }


}
