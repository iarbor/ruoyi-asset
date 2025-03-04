package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetMethod;

/**
 * 取得方式Service接口
 * 
 * @author boger
 * @date 2025-03-04
 */
public interface IAssetMethodService 
{
    /**
     * 查询取得方式
     * 
     * @param id 取得方式主键
     * @return 取得方式
     */
    public AssetMethod selectAssetMethodById(Long id);

    /**
     * 查询取得方式列表
     * 
     * @param assetMethod 取得方式
     * @return 取得方式集合
     */
    public List<AssetMethod> selectAssetMethodList(AssetMethod assetMethod);

    /**
     * 新增取得方式
     * 
     * @param assetMethod 取得方式
     * @return 结果
     */
    public int insertAssetMethod(AssetMethod assetMethod);

    /**
     * 修改取得方式
     * 
     * @param assetMethod 取得方式
     * @return 结果
     */
    public int updateAssetMethod(AssetMethod assetMethod);

    /**
     * 批量删除取得方式
     * 
     * @param ids 需要删除的取得方式主键集合
     * @return 结果
     */
    public int deleteAssetMethodByIds(Long[] ids);

    /**
     * 删除取得方式信息
     * 
     * @param id 取得方式主键
     * @return 结果
     */
    public int deleteAssetMethodById(Long id);
}
