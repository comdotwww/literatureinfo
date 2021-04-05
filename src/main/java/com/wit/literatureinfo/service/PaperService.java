package com.wit.literatureinfo.service;

import com.wit.literatureinfo.domain.Paper;

/**
 * Paper 业务逻辑接口类
 */
public interface PaperService {
    Paper selectPaperById(double id);
}
