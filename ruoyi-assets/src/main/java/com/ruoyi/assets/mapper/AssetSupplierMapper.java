package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetSupplier;

/**
 * 供应商Mapper接口
 * 
 * @author boger
 * @date 2025-03-04
 */
public interface AssetSupplierMapper 
{
    /**
     * 查询供应商
     * 
     * @param id 供应商主键
     * @return 供应商
     */
    public AssetSupplier selectAssetSupplierById(Long id);

    /**
     * 查询供应商列表
     * 
     * @param assetSupplier 供应商
     * @return 供应商集合
     */
    public List<AssetSupplier> selectAssetSupplierList(AssetSupplier assetSupplier);

    /**
     * 新增供应商
     * 
     * @param assetSupplier 供应商
     * @return 结果
     */
    public int insertAssetSupplier(AssetSupplier assetSupplier);

    /**
     * 修改供应商
     * 
     * @param assetSupplier 供应商
     * @return 结果
     */
    public int updateAssetSupplier(AssetSupplier assetSupplier);

    /**
     * 删除供应商
     * 
     * @param id 供应商主键
     * @return 结果
     */
    public int deleteAssetSupplierById(Long id);

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssetSupplierByIds(Long[] ids);
}
