package cn.svenbarnett.dframe.core.exception;

/**
 * DFrame框架异常
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-12 15:43]
 */

public class DFrameException extends RuntimeException {
    private Integer code;

    private String message;

    public DFrameException(IServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
