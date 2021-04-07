package com.wit.literatureinfo.service.impl;

import com.wit.literatureinfo.dao.AuthorDao;
import com.wit.literatureinfo.domain.Author;
import com.wit.literatureinfo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author[] selectAuthorById(double id) {
        return authorDao.selectAuthorById(id);
    }

    /**
     * 设置出现异常回滚, 默认情况下，spring 会对 unchecked 异常进行事务回滚；如果是 checked 异常则不回滚
     * Java 里面将派生于 Error 或者 RuntimeException （比如空指针，1/0）的异常称为unchecked异常，
     * 其他继承自 java.lang.Exception 的异常统称为 Checked Exception，如 IOException、TimeoutException 等
     * @param id
     * @param oldAuthor
     * @param newAuthor
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateAuthorById(double id, String oldAuthor, String newAuthor) {
        return authorDao.updateAuthorById(id, oldAuthor, newAuthor);
    }

    /**
     * 设置出现异常回滚, 默认情况下，spring 会对 unchecked 异常进行事务回滚；如果是 checked 异常则不回滚
     * Java 里面将派生于 Error 或者 RuntimeException （比如空指针，1/0）的异常称为unchecked异常，
     * 其他继承自 java.lang.Exception 的异常统称为 Checked Exception，如 IOException、TimeoutException 等
     * @param id
     * @param author
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteAuthorById(double id, String author) {
        return authorDao.deleteAuthorById(id, author);
    }

    /**
     * 设置出现异常回滚, 默认情况下，spring 会对 unchecked 异常进行事务回滚；如果是 checked 异常则不回滚
     * Java 里面将派生于 Error 或者 RuntimeException （比如空指针，1/0）的异常称为unchecked异常，
     * 其他继承自 java.lang.Exception 的异常统称为 Checked Exception，如 IOException、TimeoutException 等
     * @param id
     * @param author
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addAuthorById(double id, String author) {
        return authorDao.addAuthorById(id, author);
    }
}
