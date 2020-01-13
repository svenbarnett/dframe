package cn.svenbarnett.dframe.domain;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 附件
 *
 * @author svenbarnett
 */
@ToString
@Data
public class FrameAttachinfo {

    private String rowguid;
    private String attachname;
    private String filepath;
    private String filetype;
    private String contenttype;
    private Long filelength;
    private String clientguid;
    private String clientinfo;
    private String clienttag;
    private String filemd5;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private String userguid;
    private String updater;
}
