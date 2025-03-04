create table asset_brand  (
id  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    name varchar(50) COMMENT '品牌名称',
    code varchar(20) COMMENT '品牌代码',
    status int(11) COMMENT '状态',
    create_time date COMMENT '创建日期',
    create_by varchar(20) COMMENT '创建人',
    update_time date COMMENT '更新日期',
    update_by varchar(20) COMMENT '更新人',
    PRIMARY KEY (id)
    ) COMMENT = '品牌表';



-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品牌', '1061', '1', 'brand', 'assets/brand/index', 1, 0, 'C', '0', '0', 'assets:brand:list', '#', 'admin', sysdate(), '', null, '品牌菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品牌查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'assets:brand:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品牌新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'assets:brand:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品牌修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'assets:brand:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品牌删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'assets:brand:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品牌导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'assets:brand:export',       '#', 'admin', sysdate(), '', null, '');
