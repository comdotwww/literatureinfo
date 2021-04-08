package com.wit.literatureinfo.service.impl;

import com.wit.literatureinfo.dao.PaperDao;
import com.wit.literatureinfo.domain.Paper;
import com.wit.literatureinfo.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;

    @Override
    public Double[] selectPaperByNum(Integer limitStart, Integer limitEnd) {
        return paperDao.selectPaperByNum(limitStart, limitEnd);
    }

    @Override
    public Paper selectPaperById(double id) {
        return paperDao.selectPaperById(id);
    }

    @Override
    public Double[] selectPaperByTitle(String title, Integer limitStart, Integer limitEnd) {
        return paperDao.selectPaperByTitle(title, limitStart, limitEnd);
    }

    @Override
    public Double[] selectPaperByAuthor(String author, Integer limitStart, Integer limitEnd) {
        return paperDao.selectPaperByAuthor(author, limitStart, limitEnd);
    }

    @Override
    public Double[] selectPaperByTagDate(String tag, String date, Integer limitStart, Integer limitEnd) {
        return paperDao.selectPaperByTagDate(tag, date, limitStart, limitEnd);
    }

    @Override
    public Double[] selectPaperByTagTitle(String tag, String title, Integer limitStart, Integer limitEnd) {
        return paperDao.selectPaperByTagTitle(tag, title, limitStart, limitEnd);
    }

    @Override
    public Double[] selectPaperByTag(String tag, Integer limitStart, Integer limitEnd) {
        return paperDao.selectPaperByTag(tag, limitStart, limitEnd);
    }

    /**
     * 设置出现异常回滚, 默认情况下，spring 会对 unchecked 异常进行事务回滚；如果是 checked 异常则不回滚
     * Java 里面将派生于 Error 或者 RuntimeException （比如空指针，1/0）的异常称为unchecked异常，
     * 其他继承自 java.lang.Exception 的异常统称为 Checked Exception，如 IOException、TimeoutException 等
     * @param id
     * @param title
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateTitleById(double id, String title) {
        return paperDao.updateTitleById(id, title);
    }

    /**
     * 设置出现异常回滚, 默认情况下，spring 会对 unchecked 异常进行事务回滚；如果是 checked 异常则不回滚
     * Java 里面将派生于 Error 或者 RuntimeException （比如空指针，1/0）的异常称为unchecked异常，
     * 其他继承自 java.lang.Exception 的异常统称为 Checked Exception，如 IOException、TimeoutException 等
     * @param id
     * @param newAbstract
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateAbstractById(double id, String newAbstract) {
        return paperDao.updateAbstractById(id, newAbstract);
    }

    /**
     * 设置出现异常回滚, 默认情况下，spring 会对 unchecked 异常进行事务回滚；如果是 checked 异常则不回滚
     * Java 里面将派生于 Error 或者 RuntimeException （比如空指针，1/0）的异常称为unchecked异常，
     * 其他继承自 java.lang.Exception 的异常统称为 Checked Exception，如 IOException、TimeoutException 等
     * @param id
     * @param newUrl
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateUrlById(double id, String newUrl) {
        return paperDao.updateUrlById(id, newUrl);
    }

    /**
     * 设置出现异常回滚, 默认情况下，spring 会对 unchecked 异常进行事务回滚；如果是 checked 异常则不回滚
     * Java 里面将派生于 Error 或者 RuntimeException （比如空指针，1/0）的异常称为unchecked异常，
     * 其他继承自 java.lang.Exception 的异常统称为 Checked Exception，如 IOException、TimeoutException 等
     * @param id
     * @param newDate
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateDateById(double id, String newDate) {
        return paperDao.updateDateById(id, newDate);
    }

    /**
     * 设置出现异常回滚, 默认情况下，spring 会对 unchecked 异常进行事务回滚；如果是 checked 异常则不回滚
     * Java 里面将派生于 Error 或者 RuntimeException （比如空指针，1/0）的异常称为unchecked异常，
     * 其他继承自 java.lang.Exception 的异常统称为 Checked Exception，如 IOException、TimeoutException 等
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deletePaperById(double id) {
        return paperDao.deletePaperById(id);
    }

    @Override
    public Integer addPaperById(double id, String title, String abstractContent, String url, String date) {
        return paperDao.addPaperById(id, title, abstractContent, url, date);
    }

}
