package com.wit.literatureinfo.service;

import com.wit.literatureinfo.domain.Paper;

/**
 * Paper 业务逻辑接口类
 */
public interface PaperService {

    Paper selectPaperById(double id);

    Paper[] selectPaperByTitle(String title, Integer limitStart, Integer limitEnd);

    Double[] selectPaperByAuthor(String author, Integer limitStart, Integer limitEnd);

    Paper[] selectPaperByTagDate(String tag, String date, Integer limitStart, Integer limitEnd);

    Paper[] selectPaperByTagTitle(String tag, String title, Integer limitStart, Integer limitEnd);

    Double[] selectPaperByTag(String tag, Integer limitStart, Integer limitEnd);
}
