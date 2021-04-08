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

    public static final Logger LOGGER = LogManager.getLogger(UserRestController.class);

    /**
     * 根据 username 修改 密码
     * @param username
     * @param newPassword 修改后的密码
     * @return
     */
    @RequestMapping(value = "/api/resetpwd", method = RequestMethod.POST, params = {"username", "newPassword"})
    public Object UpdateUserPasswordByUsername(String username, String newPassword) {
        Integer affectedRows = 0;
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
//        String enPassword = encoder.encode(newPassword);
        // 出现异常需要事务回滚
        try{
            affectedRows = userService.UpdateUserPasswordByUsername(username, newPassword);
        }catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("password 修改失败", e);
        }
        return ResponseObject.returnUpdateObject(affectedRows,"affectedUserRows");
    }

}
