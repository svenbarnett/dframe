package cn.svenbarnett.dframe.core.base;

/**
 * 成功返回实体
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-12 16:06]
 */

public class SuccessResult<T> extends AbstratResult {

    public SuccessResult() {
        super.code = 200;
        super.message = "操作成功!";
    }

    public SuccessResult(T data) {
        super.code = 200;
        super.message = "操作成功!";
        super.data = data;
    }
}
