package com.ruoyi.assets.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetStorageLocationMapper;
import com.ruoyi.assets.domain.AssetStorageLocation;
import com.ruoyi.assets.service.IAssetStorageLocationService;

/**
 * 存放地点Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-04-20
 */
@Service
public class AssetStorageLocationServiceImpl implements IAssetStorageLocationService 
{
    @Autowired
    private AssetStorageLocationMapper assetStorageLocationMapper;

    /**
     * 查询存放地点
     * 
     * @param id 存放地点主键
     * @return 存放地点
     */
    @Override
    public AssetStorageLocation selectAssetStorageLocationById(Long id)
    {
        return assetStorageLocationMapper.selectAssetStorageLocationById(id);
    }

    /**
     * 查询存放地点列表
     * 
     * @param assetStorageLocation 存放地点
     * @return 存放地点
     */
    @Override
    public List<AssetStorageLocation> selectAssetStorageLocationList(AssetStorageLocation assetStorageLocation)
    {
        return assetStorageLocationMapper.selectAssetStorageLocationList(assetStorageLocation);
    }

    /**
     * 新增存放地点
     * 
     * @param assetStorageLocation 存放地点
     * @return 结果
     */
    @Override
    public int insertAssetStorageLocation(AssetStorageLocation assetStorageLocation)
    {
        assetStorageLocation.setCreateTime(DateUtils.getNowDate());
        return assetStorageLocationMapper.insertAssetStorageLocation(assetStorageLocation);
    }

    /**
     * 修改存放地点
     * 
     * @param assetStorageLocation 存放地点
     * @return 结果
     */
    @Override
    public int updateAssetStorageLocation(AssetStorageLocation assetStorageLocation)
    {
        assetStorageLocation.setUpdateTime(DateUtils.getNowDate());
        return assetStorageLocationMapper.updateAssetStorageLocation(assetStorageLocation);
    }

    /**
     * 批量删除存放地点
     * 
     * @param ids 需要删除的存放地点主键
     * @return 结果
     */
    @Override
    public int deleteAssetStorageLocationByIds(Long[] ids)
    {
        return assetStorageLocationMapper.deleteAssetStorageLocationByIds(ids);
    }

    /**
     * 删除存放地点信息
     * 
     * @param id 存放地点主键
     * @return 结果
     */
    @Override
    public int deleteAssetStorageLocationById(Long id)
    {
        return assetStorageLocationMapper.deleteAssetStorageLocationById(id);
    }
}
