package com.ruoyi.assets.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetCategoryMapper;
import com.ruoyi.assets.domain.AssetCategory;
import com.ruoyi.assets.service.IAssetCategoryService;

/**
 * 资产类别Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-04
 */
@Service
public class AssetCategoryServiceImpl implements IAssetCategoryService 
{
    @Autowired
    private AssetCategoryMapper assetCategoryMapper;

    /**
     * 查询资产类别
     * 
     * @param id 资产类别主键
     * @return 资产类别
     */
    @Override
    public AssetCategory selectAssetCategoryById(Long id)
    {
        return assetCategoryMapper.selectAssetCategoryById(id);
    }

    /**
     * 查询资产类别列表
     * 
     * @param assetCategory 资产类别
     * @return 资产类别
     */
    @Override
    public List<AssetCategory> selectAssetCategoryList(AssetCategory assetCategory)
    {
        return assetCategoryMapper.selectAssetCategoryList(assetCategory);
    }

    /**
     * 新增资产类别
     * 
     * @param assetCategory 资产类别
     * @return 结果
     */
    @Override
    public int insertAssetCategory(AssetCategory assetCategory)
    {
        assetCategory.setCreateTime(DateUtils.getNowDate());
        return assetCategoryMapper.insertAssetCategory(assetCategory);
    }

    /**
     * 修改资产类别
     * 
     * @param assetCategory 资产类别
     * @return 结果
     */
    @Override
    public int updateAssetCategory(AssetCategory assetCategory)
    {
        assetCategory.setUpdateTime(DateUtils.getNowDate());
        return assetCategoryMapper.updateAssetCategory(assetCategory);
    }

    /**
     * 批量删除资产类别
     * 
     * @param ids 需要删除的资产类别主键
     * @return 结果
     */
    @Override
    public int deleteAssetCategoryByIds(Long[] ids)
    {
        return assetCategoryMapper.deleteAssetCategoryByIds(ids);
    }

    /**
     * 删除资产类别信息
     * 
     * @param id 资产类别主键
     * @return 结果
     */
    @Override
    public int deleteAssetCategoryById(Long id)
    {
        return assetCategoryMapper.deleteAssetCategoryById(id);
    }
}
