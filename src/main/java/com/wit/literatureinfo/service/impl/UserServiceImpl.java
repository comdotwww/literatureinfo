package com.wit.literatureinfo.service.impl;

import com.wit.literatureinfo.dao.UserDao;
import com.wit.literatureinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 设置出现异常回滚, 默认情况下，spring 会对 unchecked 异常进行事务回滚；如果是 checked 异常则不回滚
     * Java 里面将派生于 Error 或者 RuntimeException （比如空指针，1/0）的异常称为unchecked异常，
     * 其他继承自 java.lang.Exception 的异常统称为 Checked Exception，如 IOException、TimeoutException 等
     * @param username
     * @param password
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer UpdateUserPasswordByUsername(String username, String password) {
        return userDao.UpdateUserPasswordByUsername(username, password);
    }
}
