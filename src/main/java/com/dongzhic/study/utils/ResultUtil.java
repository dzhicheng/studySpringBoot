package com.dongzhic.study.utils;

import com.dongzhic.study.domain.Result;

/**
 * @author dongzc
 * @date 2018/6/27 1:01
 */
public class ResultUtil {

    /**
     * 成功返回的信息
     * @param obj 返回的对象
     * @return
     */
    public static Result success (Object obj) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(obj);
        return result;
    }

    /**
     * 成功返回信息，没有数据
     * @return
     */
    public static Result success () {
        return success(null);
    }

    /***
     * 错误返回的信息
     * @param code 错误代码
     * @param msg 错误信息
     * @return
     */
    public static Result error (Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
