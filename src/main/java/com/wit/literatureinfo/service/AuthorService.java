package com.wit.literatureinfo.service;

import com.wit.literatureinfo.domain.Author;


/**
 * Author 业务逻辑接口类
 */
public interface AuthorService {
    Author[] selectAuthorById(double id);

    Integer updateAuthorById(double id, String oldAuthor, String newAuthor);

    Integer deleteAuthorById(double id, String author);

    Integer addAuthorById(double id, String author);

    Author[] selectAuthorByNum(Integer limitStart, Integer limitEnd);
}
