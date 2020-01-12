package cn.svenbarnett.dframe.core.exception;

/**
 * DFrame框架业务异常枚举
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-12 15:37]
 */
public enum DFrameExceptionEnum implements IServiceExceptionEnum {

    /**
     * 文件相关
     */
    WRITE_ERROR(403,"文件写入异常！"),
    FILE_READING_ERROR(402, "文件读取异常!"),
    FILE_NOT_FOUND(401, "文件找不到!"),
    /**
     * 服务器异常
     */
    SERVER_ERROR(500, "服务器异常");


    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    DFrameExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
