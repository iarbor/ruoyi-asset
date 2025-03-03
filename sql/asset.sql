
-- 资产类别表
-- ----------------------------
-- Table structure for asset_category
-- ----------------------------
DROP TABLE IF EXISTS `asset_category`;
CREATE TABLE `asset_category`  (
  `id` bigint(20) auto_increment COMMENT '序号',
  `name` varchar(50)  COMMENT '类别名称',
  `code` varchar(20)  COMMENT '代码',
  `status` int(11)  COMMENT '状态',
  `create_time` date  COMMENT '创建日期',
  `create_by` varchar(20)  COMMENT '创建人',
  `update_time` date  COMMENT '更新日期',
  `update_by` varchar(20)  COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB  comment = '资产类别表';



INSERT INTO `ruoyi_asset`.`sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1061, '基础数据', 0, 1, 'dict', NULL, NULL, '', 1, 0, 'M', '0', '0', NULL, 'dict', 'admin', '2025-03-03 14:11:05', '', NULL, '');

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('资产类别', '1061', '1', 'category', 'cate/category/index', 1, 0, 'C', '0', '0', 'cate:category:list', '#', 'admin', sysdate(), '', null, '资产类别菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('资产类别查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'cate:category:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('资产类别新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'cate:category:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('资产类别修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'cate:category:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('资产类别删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'cate:category:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('资产类别导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'cate:category:export',       '#', 'admin', sysdate(), '', null, '');