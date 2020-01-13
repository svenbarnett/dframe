package cn.svenbarnett.dframe.core.shiro;

import cn.svenbarnett.dframe.core.mapper.FrameUserMapper;
import cn.svenbarnett.dframe.domain.FramePermission;
import cn.svenbarnett.dframe.domain.FrameRole;
import cn.svenbarnett.dframe.domain.FrameUser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 权限验证shiro
 *
 * @author pswen/3197544360@qq.com
 * @date 2019/10/12 13:23
 * @since 1.0
 */
public class AuthRealm extends AuthorizingRealm {

    private final static Logger log = LoggerFactory.getLogger(AuthRealm.class);

    @Resource
    private FrameUserMapper frameUserMapper;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        FrameUser frameUser = (FrameUser) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new LinkedList<>();
        Set<FrameRole> roleSet = frameUser.getRoles();
        Set<String> roleList = new LinkedHashSet<>();
        if (CollectionUtils.isNotEmpty(roleSet)) {
            for (FrameRole frameRole : roleSet) {
                roleList.add(frameRole.getRoleName());
                Set<FramePermission> permissionSet = frameRole.getPermissions();
                if (CollectionUtils.isNotEmpty(permissionSet)) {
                    for (FramePermission framePermission : permissionSet) {
                        permissionList.add(frameRole.getRoleName() + ":" + framePermission.getPermissionName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        log.debug("#### 当前登录用户具备的资源权限：{}", permissionList.toString());
        info.addRoles(roleList);
        log.debug("#### 当前登录用户具备的角色权限：{}", roleList.toString());
        return info;
    }

    /**
     * 认证登录
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String loginid = usernamePasswordToken.getUsername();
        FrameUser frameUser = frameUserMapper.selectAllByLoginid(loginid);
        return new SimpleAuthenticationInfo(frameUser, frameUser.getPassword(), this.getClass().getName());
    }
}
