package cn.svenbarnett.dframe.domain;


import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

/**
 * 框架用户
 *
 * @author svenbarnett
 */
@Data
@ToString
public class FrameUser {

    private String rowguid;
    private String loginid;
    private String username;
    private String password;
    private String contacts;
    private String mobile;
    private Integer gender;
    private String email;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private String updater;
    private Set<FrameRole> roles;
}
