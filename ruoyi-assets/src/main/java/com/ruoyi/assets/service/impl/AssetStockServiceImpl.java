package com.ruoyi.assets.service.impl;

import java.util.List;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.ruoyi.assets.domain.CategoryStock;
import com.ruoyi.assets.domain.UserDept;
import com.ruoyi.assets.mapper.UserDeptMapper;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetStockMapper;
import com.ruoyi.assets.domain.AssetStock;
import com.ruoyi.assets.service.IAssetStockService;

/**
 * 库存清单Service业务层处理
 * 
 * @author boger
 * @date 2025-05-16
 */
@Service
public class AssetStockServiceImpl implements IAssetStockService 
{
    @Autowired
    private AssetStockMapper assetStockMapper;
    @Autowired
    private UserDeptMapper userDeptMapper;

    /**
     * 查询库存清单
     * 
     * @param id 库存清单主键
     * @return 库存清单
     */
    @Override
    public AssetStock selectAssetStockById(Long id)
    {
        return assetStockMapper.selectAssetStockById(id);
    }

    /**
     * 查询库存清单列表
     * 
     * @param assetStock 库存清单
     * @return 库存清单
     */
    @Override
    public List<AssetStock> selectAssetStockList(AssetStock assetStock)
    {
        return assetStockMapper.selectAssetStockList(assetStock);
    }

    /**
     * 新增库存清单
     * 
     * @param assetStock 库存清单
     * @return 结果
     */
    @Override
    public int insertAssetStock(AssetStock assetStock)
    {
        assetStock.setCreateTime(DateUtils.getNowDate());
        return assetStockMapper.insertAssetStock(assetStock);
    }

    /**
     * 修改库存清单
     * 
     * @param assetStock 库存清单
     * @return 结果
     */
    @Override
    public int updateAssetStock(AssetStock assetStock)
    {
        assetStock.setUpdateTime(DateUtils.getNowDate());
        return assetStockMapper.updateAssetStock(assetStock);
    }

    /**
     * 批量删除库存清单
     * 
     * @param ids 需要删除的库存清单主键
     * @return 结果
     */
    @Override
    public int deleteAssetStockByIds(Long[] ids)
    {
        return assetStockMapper.deleteAssetStockByIds(ids);
    }

    /**
     * 删除库存清单信息
     * 
     * @param id 库存清单主键
     * @return 结果
     */
    @Override
    public int deleteAssetStockById(Long id)
    {
        return assetStockMapper.deleteAssetStockById(id);
    }


    @Override
    public List<Tree<String>> getCategoryAndStockTreeData(AssetStock assetStock) {
        List<CategoryStock> list = assetStockMapper.getCategoryAndStockList(assetStock);
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
                    tree.putExtra("categoryId", treeNode.getCategoryId());
                    tree.putExtra("label", treeNode.getName());
                    tree.putExtra("isCategory", treeNode.getIsCategory());
                    tree.putExtra("icon", treeNode.getIcon());
                });
        return build;
    }
}
