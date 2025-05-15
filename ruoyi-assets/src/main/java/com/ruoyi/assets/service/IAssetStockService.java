package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetStock;

/**
 * 库存清单Service接口
 * 
 * @author boger
 * @date 2025-05-16
 */
public interface IAssetStockService 
{
    /**
     * 查询库存清单
     * 
     * @param id 库存清单主键
     * @return 库存清单
     */
    public AssetStock selectAssetStockById(Long id);

    /**
     * 查询库存清单列表
     * 
     * @param assetStock 库存清单
     * @return 库存清单集合
     */
    public List<AssetStock> selectAssetStockList(AssetStock assetStock);

    /**
     * 新增库存清单
     * 
     * @param assetStock 库存清单
     * @return 结果
     */
    public int insertAssetStock(AssetStock assetStock);

    /**
     * 修改库存清单
     * 
     * @param assetStock 库存清单
     * @return 结果
     */
    public int updateAssetStock(AssetStock assetStock);

    /**
     * 批量删除库存清单
     * 
     * @param ids 需要删除的库存清单主键集合
     * @return 结果
     */
    public int deleteAssetStockByIds(Long[] ids);

    /**
     * 删除库存清单信息
     * 
     * @param id 库存清单主键
     * @return 结果
     */
    public int deleteAssetStockById(Long id);
}
