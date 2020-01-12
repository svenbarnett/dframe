package cn.svenbarnett.dframe.core.base;

/**
 * 统一返回实体格式抽象
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-12 15:50]
 */

public abstract class AbstratResult<T> {
    /**
     * 状态码
     */
    protected Integer code;
    /**
     * 信息
     */
    protected String message;
    /**
     * 数据
     */
    protected T data;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
