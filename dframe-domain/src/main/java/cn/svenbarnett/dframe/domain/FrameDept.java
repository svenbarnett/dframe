package cn.svenbarnett.dframe.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 部门
 *
 * @author svenbarnett
 */

@ToString
@Data
public class FrameDept {

    private String rowguid;
    private String parentguid;
    private String name;
    private Integer status;
    private Integer ordernum;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
