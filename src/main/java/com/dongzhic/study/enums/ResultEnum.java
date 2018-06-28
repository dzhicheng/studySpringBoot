package com.dongzhic.study.enums;

/**
 * @author dongzc
 * @date 2018/6/27 11:41
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "success"),
    PRIMARY_SCHOOL(100, "我猜你可能还在小学"),
    MIDDLE_SCHOOL(101, "你可能还在中学");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
