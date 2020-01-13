package cn.svenbarnett.dframe.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

/**
 * 权限
 *
 * @author svenbarnett
 */
@Data
@ToString
public class FramePermission {

    private String rowguid;
    private String permissionName;
    private String uri;
    private String parentguid;
    private String type;
    private String creator;
    private String updater;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private Set<FrameRole> roles;

}
