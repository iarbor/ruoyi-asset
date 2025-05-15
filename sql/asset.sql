-- 资产类别表

DROP TABLE IF EXISTS asset_category;
CREATE TABLE asset_category
(
    id          bigint(20) auto_increment COMMENT '序号',
    name        varchar(50) COMMENT '类别名称',
    code        varchar(20) COMMENT '代码',
    status      int(11) COMMENT '状态',
    create_time date COMMENT '创建日期',
    create_by   varchar(20) COMMENT '创建人',
    update_time date COMMENT '更新日期',
    update_by   varchar(20) COMMENT '更新人',
    PRIMARY KEY (id)
) ENGINE = InnoDB comment = '资产类别表';

-- 品牌表
create table asset_brand
(
    id          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    name        varchar(50) COMMENT '品牌名称',
    code        varchar(20) COMMENT '品牌代码',
    status      int(11) COMMENT '状态',
    create_time date COMMENT '创建日期',
    create_by   varchar(20) COMMENT '创建人',
    update_time date COMMENT '更新日期',
    update_by   varchar(20) COMMENT '更新人',
    PRIMARY KEY (id)
) COMMENT = '品牌表';


INSERT INTO ruoyi_asset.sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query, route_name,
                                  is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time,
                                  update_by, update_time, remark)
VALUES (1061, '基础数据', 0, 1, 'dict', NULL, NULL, '', 1, 0, 'M', '0', '0', NULL, 'dict', 'admin',
        '2025-03-03 14:11:05', '', NULL, '');

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('资产类别', '1061', '1', 'category', 'cate/category/index', 1, 0, 'C', '0', '0', 'cate:category:list', '#',
        'admin', sysdate(), '', null, '资产类别菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('资产类别查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'cate:category:query', '#', 'admin', sysdate(),
        '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('资产类别新增', @parentId, '2', '#', '', 1, 0, 'F', '0', '0', 'cate:category:add', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('资产类别修改', @parentId, '3', '#', '', 1, 0, 'F', '0', '0', 'cate:category:edit', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('资产类别删除', @parentId, '4', '#', '', 1, 0, 'F', '0', '0', 'cate:category:remove', '#', 'admin', sysdate(),
        '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('资产类别导出', @parentId, '5', '#', '', 1, 0, 'F', '0', '0', 'cate:category:export', '#', 'admin', sysdate(),
        '', null, '');


-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('品牌', '1061', '1', 'brand', 'assets/brand/index', 1, 0, 'C', '0', '0', 'assets:brand:list', '#', 'admin',
        sysdate(), '', null, '品牌菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('品牌查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'assets:brand:query', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('品牌新增', @parentId, '2', '#', '', 1, 0, 'F', '0', '0', 'assets:brand:add', '#', 'admin', sysdate(), '', null,
        '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('品牌修改', @parentId, '3', '#', '', 1, 0, 'F', '0', '0', 'assets:brand:edit', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('品牌删除', @parentId, '4', '#', '', 1, 0, 'F', '0', '0', 'assets:brand:remove', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('品牌导出', @parentId, '5', '#', '', 1, 0, 'F', '0', '0', 'assets:brand:export', '#', 'admin', sysdate(), '',
        null, '');


-- 获取方式表
CREATE TABLE asset_method
(
    id          bigint(20) auto_increment COMMENT 'ID',
    name        varchar(50) COMMENT '获得方式名称',
    code        varchar(20) COMMENT '代码',
    status      int(11) COMMENT '状态',
    create_time date COMMENT '创建日期',
    create_by   varchar(20) COMMENT '创建人',
    update_time date COMMENT '更新日期',
    update_by   varchar(20) COMMENT '更新人',
    PRIMARY KEY (id)
) ENGINE = InnoDB comment = '取得方式表';


-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('取得方式', '1061', '1', 'method', 'assets/method/index', 1, 0, 'C', '0', '0', 'assets:method:list', '#',
        'admin', sysdate(), '', null, '取得方式菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('取得方式查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'assets:method:query', '#', 'admin', sysdate(),
        '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('取得方式新增', @parentId, '2', '#', '', 1, 0, 'F', '0', '0', 'assets:method:add', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('取得方式修改', @parentId, '3', '#', '', 1, 0, 'F', '0', '0', 'assets:method:edit', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('取得方式删除', @parentId, '4', '#', '', 1, 0, 'F', '0', '0', 'assets:method:remove', '#', 'admin', sysdate(),
        '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('取得方式导出', @parentId, '5', '#', '', 1, 0, 'F', '0', '0', 'assets:method:export', '#', 'admin', sysdate(),
        '', null, '');


-- 获取方式表
CREATE TABLE asset_supplier
(
    id          bigint(20) auto_increment COMMENT 'ID',
    name        varchar(50) COMMENT '供应商名称',
    type        varchar(20) comment '类型',
    contact     varchar(20) comment '联系人',
    telephone   varchar(20) comment '电话',
    address     varchar(20) comment '地址',
    code        varchar(20) COMMENT '代码',
    status      int(11) COMMENT '状态',
    create_time date COMMENT '创建日期',
    create_by   varchar(20) COMMENT '创建人',
    update_time date COMMENT '更新日期',
    update_by   varchar(20) COMMENT '更新人',
    PRIMARY KEY (id)
) ENGINE = InnoDB comment = '供应商表';


-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('供应商', '1061', '1', 'supplier', 'assets/supplier/index', 1, 0, 'C', '0', '0', 'assets:supplier:list', '#',
        'admin', sysdate(), '', null, '供应商菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('供应商查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'assets:supplier:query', '#', 'admin', sysdate(),
        '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('供应商新增', @parentId, '2', '#', '', 1, 0, 'F', '0', '0', 'assets:supplier:add', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('供应商修改', @parentId, '3', '#', '', 1, 0, 'F', '0', '0', 'assets:supplier:edit', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('供应商删除', @parentId, '4', '#', '', 1, 0, 'F', '0', '0', 'assets:supplier:remove', '#', 'admin', sysdate(),
        '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('供应商导出', @parentId, '5', '#', '', 1, 0, 'F', '0', '0', 'assets:supplier:export', '#', 'admin', sysdate(),
        '', null, '');

-- 添加三角形类型判断菜单

INSERT INTO ruoyi_asset.sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query, route_name,
                                  is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time,
                                  update_by, update_time, remark)
VALUES (1087, '三角形判断', 1086, 1, 'triagle', 'triangle/index', NULL, '', 1, 0, 'C', '0', '0', 'triagle', 'button',
        'admin', '2025-03-04 20:32:08', 'admin', '2025-03-04 20:42:40', '');
INSERT INTO ruoyi_asset.sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query, route_name,
                                  is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time,
                                  update_by, update_time, remark)
VALUES (1086, '测试演示', 0, 0, 'demo', NULL, NULL, '', 1, 0, 'M', '0', '0', '', 'question', 'admin',
        '2025-03-04 20:29:38', 'admin', '2025-03-04 20:30:11', '');


-- 品牌表
create table asset_location
(
    id          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    name        varchar(50) COMMENT '地点名称',
    code        varchar(20) COMMENT '地点代码',
    type        varchar(20) comment '类型',
    status      int(11) COMMENT '状态',
    descript    varchar(100) comment '备注',
    create_time date COMMENT '创建日期',
    create_by   varchar(20) COMMENT '创建人',
    update_time date COMMENT '更新日期',
    update_by   varchar(20) COMMENT '更新人',
    PRIMARY KEY (id)
) COMMENT = '存放地点表';

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('存放地点', '1061', '1', 'location', 'assets/location/index', 1, 0, 'C', '0', '0', 'assets:location:list', '#',
        'admin', sysdate(), '', null, '存放地点菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('存放地点查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'assets:location:query', '#', 'admin', sysdate(),
        '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('存放地点新增', @parentId, '2', '#', '', 1, 0, 'F', '0', '0', 'assets:location:add', '#', 'admin', sysdate(),
        '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('存放地点修改', @parentId, '3', '#', '', 1, 0, 'F', '0', '0', 'assets:location:edit', '#', 'admin', sysdate(),
        '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('存放地点删除', @parentId, '4', '#', '', 1, 0, 'F', '0', '0', 'assets:location:remove', '#', 'admin', sysdate(),
        '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('存放地点导出', @parentId, '5', '#', '', 1, 0, 'F', '0', '0', 'assets:location:export', '#', 'admin', sysdate(),
        '', null, '');


-- 资产库存表
create table asset_stock
(
    id          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    code        varchar(20) COMMENT '资产代码',
    name        varchar(50) COMMENT '资产名称',
    type        int comment '类型',
    supplier    bigint(20) COMMENT '供应商',
    location    bigint(20) COMMENT '存放地点',
    brand       bigint(20) COMMENT '品牌',
    method      bigint(20) COMMENT '取得方式',
    entry_time  date COMMENT '入库时间',
    status      int(11) COMMENT '状态',
    descript    varchar(100) comment '备注',
    picture     varchar(100) comment '图片',
    create_time date COMMENT '创建日期',
    create_by   varchar(20) COMMENT '创建人',
    update_time date COMMENT '更新日期',
    update_by   varchar(20) COMMENT '更新人',
    PRIMARY KEY (id)
) COMMENT = '资产库存表';



create table asset_transfer
(
    id          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    assets_id   varchar(20) COMMENT '资产编码',
    name        varchar(50) COMMENT '资产名称',
    user_id     bigint(20) comment '用户id',
    user_name   varchar(50) COMMENT '用户名称',
    dept       bigint(20) COMMENT '部门id',
    biz_time   date comment '业务时间',
    biz_type    int comment '业务类型(借用或归还)',
    descript    varchar(100) comment '备注',
    create_time date COMMENT '创建日期',
    create_by   varchar(20) COMMENT '创建人',
    update_time date COMMENT '更新日期',
    update_by   varchar(20) COMMENT '更新人',
    PRIMARY KEY (id)
) COMMENT = '资产流转表';
