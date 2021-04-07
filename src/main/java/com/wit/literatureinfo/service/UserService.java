package com.wit.literatureinfo.service;

/**
 * user 业务逻辑接口类
 */
public interface UserService {
    Integer UpdateUserPasswordByUsername(String username, String password);
}
