package com.wit.literatureinfo.controller;

import com.wit.literatureinfo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    public static final Logger LOGGER = LogManager.getLogger(TagRestController.class);

    /**
     * 根据 username 修改 密码
     * @param username
     * @param password 修改后的密码
     * @return
     */
    @RequestMapping(value = "/api/user/password", method = RequestMethod.POST, params = {"username", "password"})
    public Object UpdateUserPasswordByUsername(String username, String password) {
        Integer affectedRows = 0;
        // 出现异常需要事务回滚
        try{
            affectedRows = userService.UpdateUserPasswordByUsername(username, password);
        }catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("password 修改失败", e);
        }
        return ResponseObject.returnUpdateObject(affectedRows,"affectedUserRows");
    }

}
