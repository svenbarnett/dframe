package cn.svenbarnett.dframe.core.exception;

/**
 * 业务异常枚举接口规范
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-12 15:35]
 */
public interface IServiceExceptionEnum {

    /**
     * 获取业务异常对应错误码
     *
     * @return 错误码（代码)
     */
    Integer getCode();

    /**
     * 获取业务异常对应错误信息
     *
     * @return 错误信息
     */
    String getMessage();
}
