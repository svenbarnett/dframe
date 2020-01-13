package cn.svenbarnett.dframe.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 模块
 *
 * @author svenbarnett
 */

@ToString
@Data
public class FrameModule {

    private String rowguid;
    private String parentguid;
    private String name;
    private String icon;
    private String url;
    private String percode;
    private Integer ordernum;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;

}
