package cn.svenbarnett.dframe.core.aop;

import cn.svenbarnett.dframe.core.base.AbstratResult;
import cn.svenbarnett.dframe.core.base.ErrorResult;
import cn.svenbarnett.dframe.core.exception.DFrameException;
import cn.svenbarnett.dframe.core.exception.DFrameExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-12 16:16]
 */

public class BaseControllerExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(BaseControllerExceptionHandler.class);

    @ExceptionHandler(DFrameException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public AbstratResult error(DFrameException e) {
        log.error("dframe 业务异常：{}", e.getMessage());
        return new ErrorResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public AbstratResult error(RuntimeException e) {
        log.error("运行时异常：{}", e.getMessage());
        return new ErrorResult(DFrameExceptionEnum.SERVER_ERROR.getCode()
                , DFrameExceptionEnum.SERVER_ERROR.getMessage());
    }
}
