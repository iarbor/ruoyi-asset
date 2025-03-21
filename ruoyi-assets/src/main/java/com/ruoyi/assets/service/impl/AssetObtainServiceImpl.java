package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetObtainMapper;
import com.ruoyi.system.domain.AssetObtain;
import com.ruoyi.system.service.IAssetObtainService;

/**
 * 获取方式Service业务层处理
 * 
 * @author sb
 * @date 2025-03-21
 */
@Service
public class AssetObtainServiceImpl implements IAssetObtainService 
{
    @Autowired
    private AssetObtainMapper assetObtainMapper;

    /**
     * 查询获取方式
     * 
     * @param id 获取方式主键
     * @return 获取方式
     */
    @Override
    public AssetObtain selectAssetObtainById(Long id)
    {
        return assetObtainMapper.selectAssetObtainById(id);
    }

    /**
     * 查询获取方式列表
     * 
     * @param assetObtain 获取方式
     * @return 获取方式
     */
    @Override
    public List<AssetObtain> selectAssetObtainList(AssetObtain assetObtain)
    {
        return assetObtainMapper.selectAssetObtainList(assetObtain);
    }

    /**
     * 新增获取方式
     * 
     * @param assetObtain 获取方式
     * @return 结果
     */
    @Override
    public int insertAssetObtain(AssetObtain assetObtain)
    {
        assetObtain.setCreateTime(DateUtils.getNowDate());
        return assetObtainMapper.insertAssetObtain(assetObtain);
    }

    /**
     * 修改获取方式
     * 
     * @param assetObtain 获取方式
     * @return 结果
     */
    @Override
    public int updateAssetObtain(AssetObtain assetObtain)
    {
        assetObtain.setUpdateTime(DateUtils.getNowDate());
        return assetObtainMapper.updateAssetObtain(assetObtain);
    }

    /**
     * 批量删除获取方式
     * 
     * @param ids 需要删除的获取方式主键
     * @return 结果
     */
    @Override
    public int deleteAssetObtainByIds(Long[] ids)
    {
        return assetObtainMapper.deleteAssetObtainByIds(ids);
    }

    /**
     * 删除获取方式信息
     * 
     * @param id 获取方式主键
     * @return 结果
     */
    @Override
    public int deleteAssetObtainById(Long id)
    {
        return assetObtainMapper.deleteAssetObtainById(id);
    }
}
