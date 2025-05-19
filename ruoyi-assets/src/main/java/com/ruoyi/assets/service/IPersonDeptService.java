package com.ruoyi.assets.service;

import cn.hutool.core.lang.tree.Tree;
import com.ruoyi.assets.domain.UserDept;

import java.util.List;

public interface IPersonDeptService {

    List<UserDept> getDeptAndUserList();

    List<Tree<String>> getDeptAndUserTreeData();
}
