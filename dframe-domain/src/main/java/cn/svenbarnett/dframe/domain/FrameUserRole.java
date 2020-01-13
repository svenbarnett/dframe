package cn.svenbarnett.dframe.domain;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class FrameUserRole {

    private String userguid;
    private String roleguid;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
