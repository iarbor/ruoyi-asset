package com.ruoyi.assets.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.ruoyi.assets.domain.UserDept;
import com.ruoyi.assets.mapper.UserDeptMapper;
import com.ruoyi.assets.service.IPersonDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDeptServiceImpl implements IPersonDeptService {


    @Autowired
    private UserDeptMapper userDeptMapper;

    @Override
    public List<UserDept> getDeptAndUserList() {
        return userDeptMapper.getDeptAndUserList();
    }

    @Override
    public List<Tree<String>> getDeptAndUserTreeData() {
        List<UserDept> list = userDeptMapper.getDeptAndUserList();
//        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
//        for(DeptAndUserTreeDto dudto : list){
//            nodeList.add(new TreeNode<>(dudto.getId(),dudto.getParentId(),dudto.getName(),dudto.getOrderNum()));
//        }
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 自定义属性名 都有默认值的哈
        // 默认支持排序
        treeNodeConfig.setWeightKey("orderNum");
        //treeNodeConfig.setChildrenKey("children");

        //可配置树深度
        treeNodeConfig.setDeep(8);
        treeNodeConfig.setIdKey("id");
        List<Tree<String>> build = TreeUtil.build(list, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setWeight(treeNode.getOrderNum());
                    tree.setName(treeNode.getName());
                    // 扩展属性
                    tree.putExtra("deptId", treeNode.getDeptId());
                    tree.putExtra("label", treeNode.getName());
                    tree.putExtra("isDept", treeNode.getIsDept());
                    tree.putExtra("icon", treeNode.getIcon());
                });
        return build;
    }


}

