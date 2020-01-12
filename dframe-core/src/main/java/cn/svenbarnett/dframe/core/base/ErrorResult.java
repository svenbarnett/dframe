package cn.svenbarnett.dframe.core.base;

/**
 * 错误返回实体
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-12 16:11]
 */

public class ErrorResult extends AbstratResult {
    public ErrorResult(int code, String message) {
        super();
        super.code = code;
        super.message = message;
    }
}
