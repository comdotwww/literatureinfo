package com.wit.literatureinfo.domain;


public enum ResponseEnum {
    GET_SUCCESS(211, "数据获取成功"),
    GET_FAILED(212,"数据获取失败,id错误"),
    ADD_SUCCESS(213, "添加成功"),
    CLAZZ_EXIT(214, "数据已存在"),
    DELETE_SUCCESS(215, "删除成功"),
    DELETE_FAILED(216, "删除失败")
    ;
    private Integer code;		// 响应码
    private String message;		// 响应信息

    ResponseEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }

}
