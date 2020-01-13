package cn.svenbarnett.dframe.core.util;

/**
 * excel处理器接口
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-09 19:37]
 */
public interface ExcelParseHandler {

    void handle(int sheet, int row, Object[] data);
}
