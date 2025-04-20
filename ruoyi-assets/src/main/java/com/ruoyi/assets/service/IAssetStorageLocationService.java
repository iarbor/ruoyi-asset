package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetStorageLocation;

/**
 * 存放地点Service接口
 * 
 * @author ruoyi
 * @date 2025-04-20
 */
public interface IAssetStorageLocationService 
{
    /**
     * 查询存放地点
     * 
     * @param id 存放地点主键
     * @return 存放地点
     */
    public AssetStorageLocation selectAssetStorageLocationById(Long id);

    /**
     * 查询存放地点列表
     * 
     * @param assetStorageLocation 存放地点
     * @return 存放地点集合
     */
    public List<AssetStorageLocation> selectAssetStorageLocationList(AssetStorageLocation assetStorageLocation);

    /**
     * 新增存放地点
     * 
     * @param assetStorageLocation 存放地点
     * @return 结果
     */
    public int insertAssetStorageLocation(AssetStorageLocation assetStorageLocation);

    /**
     * 修改存放地点
     * 
     * @param assetStorageLocation 存放地点
     * @return 结果
     */
    public int updateAssetStorageLocation(AssetStorageLocation assetStorageLocation);

    /**
     * 批量删除存放地点
     * 
     * @param ids 需要删除的存放地点主键集合
     * @return 结果
     */
    public int deleteAssetStorageLocationByIds(Long[] ids);

    /**
     * 删除存放地点信息
     * 
     * @param id 存放地点主键
     * @return 结果
     */
    public int deleteAssetStorageLocationById(Long id);
}
