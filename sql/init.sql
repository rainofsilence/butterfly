-- init schema

-- 用户信息表
drop table if exists user_info;
create table user_info
(
    `id`          varchar(40) not null,
    `nickname`    varchar(100) comment '昵称',
    `username`    varchar(100) comment '账号',
    `password`    varchar(256) comment '密码',
    `real_name`   varchar(100) comment '真实姓名',
    `cert_type`   varchar(5) comment '证件类型',
    `cert_id`     varchar(100) comment '证件号码',
    `gender`      varchar(5) default '00' comment '性别',
    `inuse`       tinyint(1) default 1 comment '是否启用 1:是 0:否',
    `locked`      tinyint(1) default 0 comment '是否锁定 1:是 0:否',
    `create_time` timestamp  default current_timestamp comment '创建时间',
    `update_time` timestamp  default current_timestamp on update current_timestamp comment '更新时间',
    `delete_time` timestamp  default null comment '删除时间',
    `deleted`     tinyint(1) default 0 comment '是否删除 1:是 0:否',
    primary key (`id`)
) comment '用户信息表';
create index inx_ui_username on user_info (`username`);
create index inx_ui_uname_del on user_info (`username`, `deleted`);

-- 角色信息表
drop table if exists role_info;
create table role_info
(
    `id`          varchar(40) not null,
    `role_no`     varchar(100) comment '角色编号',
    `role_name`   varchar(256) comment '角色名称',
    `sort_no`     varchar(20) default '00' comment '排序',
    `remark`      varchar(256) comment '说明',
    `create_time` timestamp   default current_timestamp comment '创建时间',
    `update_time` timestamp   default current_timestamp on update current_timestamp comment '更新时间',
    primary key (`id`)
) comment '角色信息表';

-- 用户角色表
drop table if exists user_role;
create table user_role
(
    `user_id` varchar(40) not null,
    `role_id` varchar(40) not null,
    primary key (`user_id`, `role_id`)
) comment '用户角色表';

-- 枚举表
drop table if exists enum_info;
create table enum_info
(
    `id`        varchar(40) not null,
    `enum_no`   varchar(100) comment '枚举编号',
    `enum_name` varchar(256) comment '枚举名称',
    `remark`    varchar(256) comment '说明',
    `sort_no`   varchar(20) default '00' comment '排序',
    primary key (`id`)
) comment '枚举信息表';

-- 菜单表
drop table if exists menu_info;
create table menu_info
(
    `id`        varchar(40) not null,
    `menu_no`   varchar(100) comment '菜单编号',
    `menu_name` varchar(256) comment '菜单名称',
    `sort_no`   varchar(20) default '00' comment '排序',
    primary key (`id`)
) comment '菜单信息表';

-- 菜单权限表
drop table if exists menu_permission;
create table menu_permission
(
    `id`         varchar(40) not null,
    `menu_id`    varchar(40) not null comment '菜单id',
    `permission` varchar(256) comment '权限名称',
    `sort_no`    varchar(20) default '00' comment '排序',
    `remark`     varchar(256) comment '说明',
    primary key (`id`)
) comment '菜单权限表';

-- 角色权限表
drop table if exists role_permission;
create table role_permission
(
    `role_id` varchar(40) not null comment '角色id',
    `mp_id`   varchar(40) not null comment '菜单权限id',
    primary key (`role_id`, `mp_id`)
) comment '角色权限表';