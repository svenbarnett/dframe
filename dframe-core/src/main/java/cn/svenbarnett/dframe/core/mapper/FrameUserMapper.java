package cn.svenbarnett.dframe.core.mapper;

import cn.svenbarnett.dframe.domain.FrameUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * [简单描述]
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-13 21:17]
 */

@Mapper
public interface FrameUserMapper {

    /**
     * 根据用户loginid查询该用户角色和权限
     *
     * @param loginid 登陆id
     * @return 用户信息
     */
    List<FrameUser> selectAllByLoginid(@Param("loginid") String loginid);
}
