package com.ruoyi.assets.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetSupplierMapper;
import com.ruoyi.assets.domain.AssetSupplier;
import com.ruoyi.assets.service.IAssetSupplierService;

/**
 * 供应商Service业务层处理
 * 
 * @author boger
 * @date 2025-03-04
 */
@Service
public class AssetSupplierServiceImpl implements IAssetSupplierService 
{
    @Autowired
    private AssetSupplierMapper assetSupplierMapper;

    /**
     * 查询供应商
     * 
     * @param id 供应商主键
     * @return 供应商
     */
    @Override
    public AssetSupplier selectAssetSupplierById(Long id)
    {
        return assetSupplierMapper.selectAssetSupplierById(id);
    }

    /**
     * 查询供应商列表
     * 
     * @param assetSupplier 供应商
     * @return 供应商
     */
    @Override
    public List<AssetSupplier> selectAssetSupplierList(AssetSupplier assetSupplier)
    {
        return assetSupplierMapper.selectAssetSupplierList(assetSupplier);
    }

    /**
     * 新增供应商
     * 
     * @param assetSupplier 供应商
     * @return 结果
     */
    @Override
    public int insertAssetSupplier(AssetSupplier assetSupplier)
    {
        assetSupplier.setCreateTime(DateUtils.getNowDate());
        return assetSupplierMapper.insertAssetSupplier(assetSupplier);
    }

    /**
     * 修改供应商
     * 
     * @param assetSupplier 供应商
     * @return 结果
     */
    @Override
    public int updateAssetSupplier(AssetSupplier assetSupplier)
    {
        assetSupplier.setUpdateTime(DateUtils.getNowDate());
        return assetSupplierMapper.updateAssetSupplier(assetSupplier);
    }

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的供应商主键
     * @return 结果
     */
    @Override
    public int deleteAssetSupplierByIds(Long[] ids)
    {
        return assetSupplierMapper.deleteAssetSupplierByIds(ids);
    }

    /**
     * 删除供应商信息
     * 
     * @param id 供应商主键
     * @return 结果
     */
    @Override
    public int deleteAssetSupplierById(Long id)
    {
        return assetSupplierMapper.deleteAssetSupplierById(id);
    }
}
