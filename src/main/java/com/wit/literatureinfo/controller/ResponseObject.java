package com.wit.literatureinfo.controller;

import com.wit.literatureinfo.domain.ResponseEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 对返回对象的处理
 */
public class ResponseObject {
    /**
     *
     * @param obj1  paper
     * @param obj2  author
     * @param obj3  tag
     * @return
     */
    public static Object returnObject(Object obj1, Object obj2, Object obj3){
        if (obj1 != null) {
            Map<String, Object> maps = new HashMap<>();
            String message = ResponseEnum.GET_SUCCESS.getMessage();
            Integer code = ResponseEnum.GET_SUCCESS.getCode();

            // tag
            maps.put("tag", obj3);
            // author
            maps.put("author", obj2);
            // paper
            maps.put("paper", obj1);
            // message
            maps.put("message", message);
            // code
            maps.put("code", code);

            return maps;

        }else {
            Map<String, Object> map = new HashMap();
            map.put("message", ResponseEnum.GET_FAILED.getMessage());
            map.put("code", ResponseEnum.GET_FAILED.getCode());
            return map;
        }
    }

    /**
     *
     * @param obj   author 或 tag
     * @param name
     * @return
     */
    public static Object returnObject(Object obj, String name) {
        if (obj != null ) {
            Map<String, Object> maps = new HashMap<>();
            String message = ResponseEnum.GET_SUCCESS.getMessage();
            Integer code = ResponseEnum.GET_SUCCESS.getCode();

            maps.put(name, obj);
            // message
            maps.put("message", message);
            // code
            maps.put("code", code);
            return maps;
        }else {
            Map<String, Object> map = new HashMap();
            map.put("message", ResponseEnum.GET_FAILED.getMessage());
            map.put("code", ResponseEnum.GET_FAILED.getCode());
            return map;
        }
    }
}
