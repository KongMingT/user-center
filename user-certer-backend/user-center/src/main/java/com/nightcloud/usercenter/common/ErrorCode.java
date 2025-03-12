package com.nightcloud.usercenter.common;

/**
 * 错误码
 */
public enum ErrorCode {

    SUCCESS(0,"success",""),
    PARAMS_ERROR(40000,"请求参数错误",""),
    NULL_ERROR(40001,"空值错误",""),
    NO_AUTH(40100,"无权限",""),
    NOT_LOGIN(40101,"用户未登录",""),
    SYSTEM_ERROR(50000,"系统内部错误","");


    /**
     * 状态码
     */
    private final int code;

    /**
     * 状态码信息
     */
    private final String message;

    /**
     * 状态码描述
     */
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
