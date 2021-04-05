package com.wit.literatureinfo.service.impl;

import com.wit.literatureinfo.dao.AuthorDao;
import com.wit.literatureinfo.domain.Author;
import com.wit.literatureinfo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author[] selectAuthorById(double id) {
        return authorDao.selectAuthorById(id);
    }
}
