package com.dongzhic.study.handle;

import com.dongzhic.study.domain.Result;
import com.dongzhic.study.exception.GirlException;
import com.dongzhic.study.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dongzc
 * @date 2018/6/27 11:04
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(GirlException.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle (Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.info("系统异常：{}", e);
            return ResultUtil.error(-1, "未知错误");
        }

    }

}
