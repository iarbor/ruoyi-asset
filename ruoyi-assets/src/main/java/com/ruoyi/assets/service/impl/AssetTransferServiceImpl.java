package com.ruoyi.assets.service.impl;

import java.util.List;

import com.ruoyi.assets.domain.AssetStock;
import com.ruoyi.assets.mapper.AssetStockMapper;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetTransferMapper;
import com.ruoyi.assets.domain.AssetTransfer;
import com.ruoyi.assets.service.IAssetTransferService;

/**
 * 资产流转Service业务层处理
 * 
 * @author boger
 * @date 2025-05-16
 */
@Service
public class AssetTransferServiceImpl implements IAssetTransferService 
{
    @Autowired
    private AssetTransferMapper assetTransferMapper;
    @Autowired
    private AssetStockMapper assetStockMapper;

    /**
     * 查询资产流转
     * 
     * @param id 资产流转主键
     * @return 资产流转
     */
    @Override
    public AssetTransfer selectAssetTransferById(Long id)
    {
        return assetTransferMapper.selectAssetTransferById(id);
    }

    /**
     * 查询资产流转列表
     * 
     * @param assetTransfer 资产流转
     * @return 资产流转
     */
    @Override
    public List<AssetTransfer> selectAssetTransferList(AssetTransfer assetTransfer)
    {
        return assetTransferMapper.selectAssetTransferList(assetTransfer);
    }

    /**
     * 新增资产流转
     * 
     * @param assetTransfer 资产流转
     * @return 结果
     */
    @Override
    public int insertAssetTransfer(AssetTransfer assetTransfer)
    {
        assetTransfer.setCreateTime(DateUtils.getNowDate());
        int r =  assetTransferMapper.insertAssetTransfer(assetTransfer);
        if(assetTransfer.getBizType()==1){
            AssetStock assetStock = new AssetStock();
            assetStock.setId(assetTransfer.getAssetsId());
            assetStock.setStatus(2L);
            assetStockMapper.updateAssetStock(assetStock);
        }
        else if(assetTransfer.getBizType()==2){
            AssetStock assetStock = new AssetStock();
            assetStock.setId(assetTransfer.getAssetsId());
            assetStock.setStatus(1L);
            assetStockMapper.updateAssetStock(assetStock);
        }
        return r;

    }

    /**
     * 修改资产流转
     * 
     * @param assetTransfer 资产流转
     * @return 结果
     */
    @Override
    public int updateAssetTransfer(AssetTransfer assetTransfer)
    {
        assetTransfer.setUpdateTime(DateUtils.getNowDate());
        return assetTransferMapper.updateAssetTransfer(assetTransfer);
    }

    /**
     * 批量删除资产流转
     * 
     * @param ids 需要删除的资产流转主键
     * @return 结果
     */
    @Override
    public int deleteAssetTransferByIds(Long[] ids)
    {
        return assetTransferMapper.deleteAssetTransferByIds(ids);
    }

    /**
     * 删除资产流转信息
     * 
     * @param id 资产流转主键
     * @return 结果
     */
    @Override
    public int deleteAssetTransferById(Long id)
    {
        return assetTransferMapper.deleteAssetTransferById(id);
    }
}
