package com.ruoyi.assets.mapper;

import com.ruoyi.assets.domain.UserDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDeptMapper extends Mapper {

    @Select("SELECT sys_dept.dept_id id,sys_dept.dept_id deptId,sys_dept.parent_id parentId,1 as isDept,sys_dept.dept_name NAME,'el-icon-folder' AS icon,TRUE AS disabled,sys_dept.order_num AS orderNum FROM sys_dept WHERE sys_dept.status=0  "
            + "union ALL "
            + "SELECT sys_user.user_id id,sys_user.dept_id deptId,sys_user.dept_id parentId,0 as isDept,sys_user.nick_name NAME,'el-icon-user-solid' AS icon,FALSE AS disabled,999 AS orderNum FROM sys_user WHERE sys_user.status=0 ORDER BY orderNum ASC")
    List<UserDept> getDeptAndUserList();


}
