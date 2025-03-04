package com.ruoyi.assets.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetMethodMapper;
import com.ruoyi.assets.domain.AssetMethod;
import com.ruoyi.assets.service.IAssetMethodService;

/**
 * 取得方式Service业务层处理
 * 
 * @author boger
 * @date 2025-03-04
 */
@Service
public class AssetMethodServiceImpl implements IAssetMethodService 
{
    @Autowired
    private AssetMethodMapper assetMethodMapper;

    /**
     * 查询取得方式
     * 
     * @param id 取得方式主键
     * @return 取得方式
     */
    @Override
    public AssetMethod selectAssetMethodById(Long id)
    {
        return assetMethodMapper.selectAssetMethodById(id);
    }

    /**
     * 查询取得方式列表
     * 
     * @param assetMethod 取得方式
     * @return 取得方式
     */
    @Override
    public List<AssetMethod> selectAssetMethodList(AssetMethod assetMethod)
    {
        return assetMethodMapper.selectAssetMethodList(assetMethod);
    }

    /**
     * 新增取得方式
     * 
     * @param assetMethod 取得方式
     * @return 结果
     */
    @Override
    public int insertAssetMethod(AssetMethod assetMethod)
    {
        assetMethod.setCreateTime(DateUtils.getNowDate());
        return assetMethodMapper.insertAssetMethod(assetMethod);
    }

    /**
     * 修改取得方式
     * 
     * @param assetMethod 取得方式
     * @return 结果
     */
    @Override
    public int updateAssetMethod(AssetMethod assetMethod)
    {
        assetMethod.setUpdateTime(DateUtils.getNowDate());
        return assetMethodMapper.updateAssetMethod(assetMethod);
    }

    /**
     * 批量删除取得方式
     * 
     * @param ids 需要删除的取得方式主键
     * @return 结果
     */
    @Override
    public int deleteAssetMethodByIds(Long[] ids)
    {
        return assetMethodMapper.deleteAssetMethodByIds(ids);
    }

    /**
     * 删除取得方式信息
     * 
     * @param id 取得方式主键
     * @return 结果
     */
    @Override
    public int deleteAssetMethodById(Long id)
    {
        return assetMethodMapper.deleteAssetMethodById(id);
    }
}
