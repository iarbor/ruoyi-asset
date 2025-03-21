package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AssetObtain;

/**
 * 获取方式Service接口
 * 
 * @author sb
 * @date 2025-03-21
 */
public interface IAssetObtainService 
{
    /**
     * 查询获取方式
     * 
     * @param id 获取方式主键
     * @return 获取方式
     */
    public AssetObtain selectAssetObtainById(Long id);

    /**
     * 查询获取方式列表
     * 
     * @param assetObtain 获取方式
     * @return 获取方式集合
     */
    public List<AssetObtain> selectAssetObtainList(AssetObtain assetObtain);

    /**
     * 新增获取方式
     * 
     * @param assetObtain 获取方式
     * @return 结果
     */
    public int insertAssetObtain(AssetObtain assetObtain);

    /**
     * 修改获取方式
     * 
     * @param assetObtain 获取方式
     * @return 结果
     */
    public int updateAssetObtain(AssetObtain assetObtain);

    /**
     * 批量删除获取方式
     * 
     * @param ids 需要删除的获取方式主键集合
     * @return 结果
     */
    public int deleteAssetObtainByIds(Long[] ids);

    /**
     * 删除获取方式信息
     * 
     * @param id 获取方式主键
     * @return 结果
     */
    public int deleteAssetObtainById(Long id);
}
