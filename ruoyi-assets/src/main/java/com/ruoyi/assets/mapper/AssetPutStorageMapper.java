package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetPutStorage;

/**
 * 入库Mapper接口
 * 
 * @author ruoyi
 * @date 2025-04-20
 */
public interface AssetPutStorageMapper 
{
    /**
     * 查询入库
     * 
     * @param id 入库主键
     * @return 入库
     */
    public AssetPutStorage selectAssetPutStorageById(Long id);

    /**
     * 查询入库列表
     * 
     * @param assetPutStorage 入库
     * @return 入库集合
     */
    public List<AssetPutStorage> selectAssetPutStorageList(AssetPutStorage assetPutStorage);

    /**
     * 新增入库
     * 
     * @param assetPutStorage 入库
     * @return 结果
     */
    public int insertAssetPutStorage(AssetPutStorage assetPutStorage);

    /**
     * 修改入库
     * 
     * @param assetPutStorage 入库
     * @return 结果
     */
    public int updateAssetPutStorage(AssetPutStorage assetPutStorage);

    /**
     * 删除入库
     * 
     * @param id 入库主键
     * @return 结果
     */
    public int deleteAssetPutStorageById(Long id);

    /**
     * 批量删除入库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssetPutStorageByIds(Long[] ids);
}
