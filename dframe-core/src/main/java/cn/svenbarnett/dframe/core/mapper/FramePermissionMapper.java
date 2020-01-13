package cn.svenbarnett.dframe.core.mapper;

import cn.svenbarnett.dframe.domain.FramePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * [简单描述]
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-13 21:24]
 */
@Mapper
public interface FramePermissionMapper {

    /**
     * 查询全部权限和角色关联信息
     *
     * @return 权限角色信息
     */
    List<FramePermission> selectAll();
}
