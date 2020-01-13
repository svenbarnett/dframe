-- 框架用户表 --
drop table if exists `frame_user`;
create table `frame_user`
(
    `rowguid`     varchar(50) not null comment '主键',
    `loginid`     varchar(32)  default '' comment '登录名',
    `username`    varchar(32)  default '' comment '用户名',
    `password`    varchar(255) default '' comment '密码',
    `contacts`    varchar(32)  default null comment '联系人',
    `mobile`      varchar(11)  default '' comment '手机号',
    `gender`      tinyint(1)   default 0 comment '性别，0：保密 1：男 2：女',
    `email`       varchar(64)  default '' comment '邮箱',
    `status`      tinyint(255) default 1 comment '状态，0：禁用 1：启用',
    `create_time` datetime     default current_timestamp comment '创建时间',
    `update_time` datetime comment '更新时间',
    `delete_time` datetime comment '删除时间',
    `updater`     varchar(32)  default '' comment '操作用户',
    primary key (`rowguid`) using btree
) engine = innodb
  default charset = utf8mb4 comment ='用户表';


-- 框架角色表 --
drop table if exists `frame_role`;
create table `frame_role`
(
    `rowguid`     varchar(50) not null comment '角色唯一主键',
    `role_name`   varchar(50) not null comment '角色名称',
    `status`      tinyint(1)  default 1 comment '角色状态，0：禁用 1：启用',
    `creator`     varchar(32) default '',
    `updater`     varchar(32) default '',
    `create_time` datetime    default current_timestamp comment '创建时间',
    `update_time` datetime comment '更新时间',
    `delete_time` datetime comment '删除时间',
    primary key (`rowguid`) using btree
) engine = innodb
  default charset = utf8mb4 comment ='角色表';


-- 框架权限表 --
drop table if exists `frame_permission`;
create table `frame_permission`
(
    `rowguid`         varchar(50)  not null comment '权限唯一主键',
    `permission_name` varchar(50)  not null comment '权限名称',
    `uri`             varchar(500) not null comment '资源',
    `parentguid`      varchar(50) comment '父权限id',
    `type`            varchar(16) default 'button' comment '权限类型',
    `creator`         varchar(32) default '',
    `updater`         varchar(32) default '',
    `create_time`     datetime    default current_timestamp comment '创建时间',
    `update_time`     datetime comment '更新时间',
    `delete_time`     datetime comment '删除时间',
    primary key (`rowguid`) using btree
) engine = innodb
  default charset = utf8mb4;

-- 用户-角色表 --
drop table if exists `frame_user_role`;
create table frame_user_role
(
    `userguid`    varchar(50) comment '用户id',
    `roleguid`    varchar(50) comment '角色id',
    `create_time` datetime default current_timestamp comment '创建时间',
    `update_time` datetime comment '更新时间',
    `delete_time` datetime comment '删除时间',
    key idx_rid (`roleguid`),
    key idx_uid (`userguid`)
) engine = innodb
  default charset = utf8mb4 comment ='用户-角色表';


-- 角色-权限表 --
drop table if exists `frame_role_permission`;
create table `frame_role_permission`
(
    `roleguid`       varchar(50) comment '角色id',
    `permissionguid` varchar(50) comment '权限id',
    `create_time`    datetime default current_timestamp comment '创建时间',
    `update_time`    datetime comment '更新时间',
    `delete_time`    datetime comment '删除时间',
    key idx_rid (`roleguid`),
    key idx_pid (`permissionguid`)
) engine = innodb
  default charset = utf8mb4 comment ='角色-权限表';

-- 框架部门表 --
drop table if exists `frame_dept`;
create table `frame_dept`
(
    `rowguid`     varchar(50) not null comment '部门主键',
    `parentguid`  varchar(50) comment '上一级部门id',
    `name`        varchar(50) not null comment '部门名称',
    `status`      tinyint(1)  not null default 1 comment '是否启用；1启用，0不启用',
    `ordernum`    integer(11)          default 0 comment '排序',
    `create_time` datetime             default current_timestamp comment '创建时间',
    `update_time` datetime comment '更新时间',
    `delete_time` datetime comment '删除时间',
    primary key (`rowguid`) using btree,
    key idx_pid (`parentguid`)
) engine = innodb
  default charset = utf8mb4 comment ='框架部门表';

-- 框架模块表 --
drop table if exists `frame_module`;
create table `frame_module`
(
    `rowguid`     varchar(50) not null comment '模块主键',
    `parentguid`  varchar(50) comment '上一级模块id',
    `name`        varchar(50) not null comment '名称',
    `icon`        varchar(50) comment '图标',
    `url`         varchar(255) comment '对应的url',
    `percode`     varchar(50) comment '权限',
    `ordernum`    integer(11)          default 0 comment '排序',
    `status`      tinyint(1)  not null default 1 comment '是否启用；1启用，0不启用',
    `create_time` datetime             default current_timestamp comment '创建时间',
    `update_time` datetime comment '更新时间',
    `delete_time` datetime comment '删除时间',
    primary key (`rowguid`) using btree,
    key idx_pid (`parentguid`)
) engine = innodb
  default charset = utf8mb4 comment ='框架模块表';

-- 框架附件表 --
drop table if exists `frame_attachinfo`;
create table `frame_attachinfo`
(
    `rowguid`     varchar(50) not null comment '附件guid',
    `attachname`  varchar(32)  default '' comment '附件名',
    `filepath`    varchar(500) default '' comment '附件文件位置',
    `filetype`    varchar(32)  default '' comment '附件后缀',
    `contenttype` varchar(255) default '' comment '附件类型',
    `filelength`  bigint(20)   default 0 comment '附件大小',
    `clientguid`  varchar(50)  default '' comment '客户端id',
    `clientinfo`  varchar(50)  default '' comment '附件信息',
    `clienttag`   varchar(50)  default '' comment '附件标签',
    `filemd5`     varchar(50)  default '' comment '附件md5值',
    `create_time` datetime     default current_timestamp comment '创建时间',
    `update_time` datetime comment '更新时间',
    `delete_time` datetime comment '删除时间',
    `userguid`    varchar(50) comment '用户guid',
    `updater`     varchar(32)  default '' comment '操作用户',
    primary key (`rowguid`) using btree
) engine = innodb
  default charset = utf8mb4 comment ='附件表';

