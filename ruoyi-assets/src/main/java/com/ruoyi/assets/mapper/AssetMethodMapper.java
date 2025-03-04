package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetMethod;

/**
 * 取得方式Mapper接口
 * 
 * @author boger
 * @date 2025-03-04
 */
public interface AssetMethodMapper 
{
    /**
     * 查询取得方式
     * 
     * @param id 取得方式主键
     * @return 取得方式
     */
    public AssetMethod selectAssetMethodById(Long id);

    /**
     * 查询取得方式列表
     * 
     * @param assetMethod 取得方式
     * @return 取得方式集合
     */
    public List<AssetMethod> selectAssetMethodList(AssetMethod assetMethod);

    /**
     * 新增取得方式
     * 
     * @param assetMethod 取得方式
     * @return 结果
     */
    public int insertAssetMethod(AssetMethod assetMethod);

    /**
     * 修改取得方式
     * 
     * @param assetMethod 取得方式
     * @return 结果
     */
    public int updateAssetMethod(AssetMethod assetMethod);

    /**
     * 删除取得方式
     * 
     * @param id 取得方式主键
     * @return 结果
     */
    public int deleteAssetMethodById(Long id);

    /**
     * 批量删除取得方式
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssetMethodByIds(Long[] ids);
}
