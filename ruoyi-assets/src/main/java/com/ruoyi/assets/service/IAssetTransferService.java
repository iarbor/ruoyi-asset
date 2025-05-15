package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetTransfer;

/**
 * 资产流转Service接口
 * 
 * @author boger
 * @date 2025-05-16
 */
public interface IAssetTransferService 
{
    /**
     * 查询资产流转
     * 
     * @param id 资产流转主键
     * @return 资产流转
     */
    public AssetTransfer selectAssetTransferById(Long id);

    /**
     * 查询资产流转列表
     * 
     * @param assetTransfer 资产流转
     * @return 资产流转集合
     */
    public List<AssetTransfer> selectAssetTransferList(AssetTransfer assetTransfer);

    /**
     * 新增资产流转
     * 
     * @param assetTransfer 资产流转
     * @return 结果
     */
    public int insertAssetTransfer(AssetTransfer assetTransfer);

    /**
     * 修改资产流转
     * 
     * @param assetTransfer 资产流转
     * @return 结果
     */
    public int updateAssetTransfer(AssetTransfer assetTransfer);

    /**
     * 批量删除资产流转
     * 
     * @param ids 需要删除的资产流转主键集合
     * @return 结果
     */
    public int deleteAssetTransferByIds(Long[] ids);

    /**
     * 删除资产流转信息
     * 
     * @param id 资产流转主键
     * @return 结果
     */
    public int deleteAssetTransferById(Long id);
}
