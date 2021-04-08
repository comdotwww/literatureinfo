package com.wit.literatureinfo.service;

import com.wit.literatureinfo.domain.Paper;

/**
 * Paper 业务逻辑接口类
 */
public interface PaperService {

    Paper selectPaperById(double id);

    Double[] selectPaperByTitle(String title, Integer limitStart, Integer limitEnd);

    Double[] selectPaperByAuthor(String author, Integer limitStart, Integer limitEnd);

    Double[] selectPaperByTagDate(String tag, String date, Integer limitStart, Integer limitEnd);

    Double[] selectPaperByTagTitle(String tag, String title, Integer limitStart, Integer limitEnd);

    Double[] selectPaperByTag(String tag, Integer limitStart, Integer limitEnd);

    Integer updateTitleById(double id, String title);

    Integer updateAbstractById(double id, String newAbstract);

    Integer updateUrlById(double id, String newUrl);

    Integer updateDateById(double id, String newDate);

    Integer deletePaperById(double id);

    Integer addPaperById(double id, String title, String abstractContent, String url, String date);

    Double[] selectPaperByNum(Integer limitStart, Integer limitEnd);
}
