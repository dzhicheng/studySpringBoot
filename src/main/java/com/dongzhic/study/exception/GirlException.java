package com.dongzhic.study.exception;

import com.dongzhic.study.enums.ResultEnum;

/**
 * @author dongzc
 * @date 2018/6/27 10:41
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException (ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
