package com.wit.literatureinfo.service.impl;

import com.wit.literatureinfo.dao.PaperDao;
import com.wit.literatureinfo.domain.Paper;
import com.wit.literatureinfo.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;

    @Override
    public Paper selectPaperById(double id) {
        return paperDao.selectPaperById(id);
    }

    @Override
    public Paper[] selectPaperByTitle(String title, Integer limitStart, Integer limitEnd) {
        return paperDao.selectPaperByTitle(title, limitStart, limitEnd);
    }
}
