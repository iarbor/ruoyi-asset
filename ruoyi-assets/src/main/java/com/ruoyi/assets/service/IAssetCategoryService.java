package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetCategory;

/**
 * 资产类别Service接口
 * 
 * @author ruoyi
 * @date 2025-03-03
 */
public interface IAssetCategoryService 
{
    /**
     * 查询资产类别
     * 
     * @param id 资产类别主键
     * @return 资产类别
     */
    public AssetCategory selectAssetCategoryById(Long id);

    /**
     * 查询资产类别列表
     * 
     * @param assetCategory 资产类别
     * @return 资产类别集合
     */
    public List<AssetCategory> selectAssetCategoryList(AssetCategory assetCategory);

    /**
     * 新增资产类别
     * 
     * @param assetCategory 资产类别
     * @return 结果
     */
    public int insertAssetCategory(AssetCategory assetCategory);

    /**
     * 修改资产类别
     * 
     * @param assetCategory 资产类别
     * @return 结果
     */
    public int updateAssetCategory(AssetCategory assetCategory);

    /**
     * 批量删除资产类别
     * 
     * @param ids 需要删除的资产类别主键集合
     * @return 结果
     */
    public int deleteAssetCategoryByIds(Long[] ids);

    /**
     * 删除资产类别信息
     * 
     * @param id 资产类别主键
     * @return 结果
     */
    public int deleteAssetCategoryById(Long id);
}
