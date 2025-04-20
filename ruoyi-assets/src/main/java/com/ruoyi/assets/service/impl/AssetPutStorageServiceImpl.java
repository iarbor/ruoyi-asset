package com.ruoyi.assets.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetPutStorageMapper;
import com.ruoyi.assets.domain.AssetPutStorage;
import com.ruoyi.assets.service.IAssetPutStorageService;

/**
 * 入库Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-04-20
 */
@Service
public class AssetPutStorageServiceImpl implements IAssetPutStorageService 
{
    @Autowired
    private AssetPutStorageMapper assetPutStorageMapper;

    /**
     * 查询入库
     * 
     * @param id 入库主键
     * @return 入库
     */
    @Override
    public AssetPutStorage selectAssetPutStorageById(Long id)
    {
        return assetPutStorageMapper.selectAssetPutStorageById(id);
    }

    /**
     * 查询入库列表
     * 
     * @param assetPutStorage 入库
     * @return 入库
     */
    @Override
    public List<AssetPutStorage> selectAssetPutStorageList(AssetPutStorage assetPutStorage)
    {
        return assetPutStorageMapper.selectAssetPutStorageList(assetPutStorage);
    }

    /**
     * 新增入库
     * 
     * @param assetPutStorage 入库
     * @return 结果
     */
    @Override
    public int insertAssetPutStorage(AssetPutStorage assetPutStorage)
    {
        assetPutStorage.setCreateTime(DateUtils.getNowDate());
        return assetPutStorageMapper.insertAssetPutStorage(assetPutStorage);
    }

    /**
     * 修改入库
     * 
     * @param assetPutStorage 入库
     * @return 结果
     */
    @Override
    public int updateAssetPutStorage(AssetPutStorage assetPutStorage)
    {
        assetPutStorage.setUpdateTime(DateUtils.getNowDate());
        return assetPutStorageMapper.updateAssetPutStorage(assetPutStorage);
    }

    /**
     * 批量删除入库
     * 
     * @param ids 需要删除的入库主键
     * @return 结果
     */
    @Override
    public int deleteAssetPutStorageByIds(Long[] ids)
    {
        return assetPutStorageMapper.deleteAssetPutStorageByIds(ids);
    }

    /**
     * 删除入库信息
     * 
     * @param id 入库主键
     * @return 结果
     */
    @Override
    public int deleteAssetPutStorageById(Long id)
    {
        return assetPutStorageMapper.deleteAssetPutStorageById(id);
    }
}
