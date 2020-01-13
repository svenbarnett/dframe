package cn.svenbarnett.dframe.domain;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class FrameRolePermission {

    private String roleguid;
    private String permissionguid;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;

}
