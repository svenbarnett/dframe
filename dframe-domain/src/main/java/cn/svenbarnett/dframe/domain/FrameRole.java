package cn.svenbarnett.dframe.domain;


import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Data
@ToString
public class FrameRole {

    private String rowguid;
    private String roleName;
    private Integer status;
    private String creator;
    private String updater;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private Set<FramePermission> permissions;
}
