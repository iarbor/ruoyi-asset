package com.ruoyi.assets.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetLocationMapper;
import com.ruoyi.assets.domain.AssetLocation;
import com.ruoyi.assets.service.IAssetLocationService;

/**
 * 存放地点Service业务层处理
 * 
 * @author boger
 * @date 2025-05-14
 */
@Service
public class AssetLocationServiceImpl implements IAssetLocationService 
{
    @Autowired
    private AssetLocationMapper assetLocationMapper;

    /**
     * 查询存放地点
     * 
     * @param id 存放地点主键
     * @return 存放地点
     */
    @Override
    public AssetLocation selectAssetLocationById(Long id)
    {
        return assetLocationMapper.selectAssetLocationById(id);
    }

    /**
     * 查询存放地点列表
     * 
     * @param assetLocation 存放地点
     * @return 存放地点
     */
    @Override
    public List<AssetLocation> selectAssetLocationList(AssetLocation assetLocation)
    {
        return assetLocationMapper.selectAssetLocationList(assetLocation);
    }

    /**
     * 新增存放地点
     * 
     * @param assetLocation 存放地点
     * @return 结果
     */
    @Override
    public int insertAssetLocation(AssetLocation assetLocation)
    {
        assetLocation.setCreateTime(DateUtils.getNowDate());
        return assetLocationMapper.insertAssetLocation(assetLocation);
    }

    /**
     * 修改存放地点
     * 
     * @param assetLocation 存放地点
     * @return 结果
     */
    @Override
    public int updateAssetLocation(AssetLocation assetLocation)
    {
        assetLocation.setUpdateTime(DateUtils.getNowDate());
        return assetLocationMapper.updateAssetLocation(assetLocation);
    }

    /**
     * 批量删除存放地点
     * 
     * @param ids 需要删除的存放地点主键
     * @return 结果
     */
    @Override
    public int deleteAssetLocationByIds(Long[] ids)
    {
        return assetLocationMapper.deleteAssetLocationByIds(ids);
    }

    /**
     * 删除存放地点信息
     * 
     * @param id 存放地点主键
     * @return 结果
     */
    @Override
    public int deleteAssetLocationById(Long id)
    {
        return assetLocationMapper.deleteAssetLocationById(id);
    }
}
