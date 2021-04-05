package com.wit.literatureinfo.service;

import com.wit.literatureinfo.domain.Tag;

/**
 * Tag 业务逻辑接口类
 */
public interface TagService {
    Tag[] selectTagById(double id);
    Integer updateTagById(double id, String oldTag, String newTag);
}
