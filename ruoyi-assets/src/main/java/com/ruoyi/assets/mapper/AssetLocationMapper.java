package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetLocation;

/**
 * 存放地点Mapper接口
 * 
 * @author boger
 * @date 2025-05-14
 */
public interface AssetLocationMapper 
{
    /**
     * 查询存放地点
     * 
     * @param id 存放地点主键
     * @return 存放地点
     */
    public AssetLocation selectAssetLocationById(Long id);

    /**
     * 查询存放地点列表
     * 
     * @param assetLocation 存放地点
     * @return 存放地点集合
     */
    public List<AssetLocation> selectAssetLocationList(AssetLocation assetLocation);

    /**
     * 新增存放地点
     * 
     * @param assetLocation 存放地点
     * @return 结果
     */
    public int insertAssetLocation(AssetLocation assetLocation);

    /**
     * 修改存放地点
     * 
     * @param assetLocation 存放地点
     * @return 结果
     */
    public int updateAssetLocation(AssetLocation assetLocation);

    /**
     * 删除存放地点
     * 
     * @param id 存放地点主键
     * @return 结果
     */
    public int deleteAssetLocationById(Long id);

    /**
     * 批量删除存放地点
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssetLocationByIds(Long[] ids);
}
