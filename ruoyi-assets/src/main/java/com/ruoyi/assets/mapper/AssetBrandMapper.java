package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetBrand;

/**
 * 品牌Mapper接口
 * 
 * @author boger
 * @date 2025-03-04
 */
public interface AssetBrandMapper 
{
    /**
     * 查询品牌
     * 
     * @param id 品牌主键
     * @return 品牌
     */
    public AssetBrand selectAssetBrandById(Long id);

    /**
     * 查询品牌列表
     * 
     * @param assetBrand 品牌
     * @return 品牌集合
     */
    public List<AssetBrand> selectAssetBrandList(AssetBrand assetBrand);

    /**
     * 新增品牌
     * 
     * @param assetBrand 品牌
     * @return 结果
     */
    public int insertAssetBrand(AssetBrand assetBrand);

    /**
     * 修改品牌
     * 
     * @param assetBrand 品牌
     * @return 结果
     */
    public int updateAssetBrand(AssetBrand assetBrand);

    /**
     * 删除品牌
     * 
     * @param id 品牌主键
     * @return 结果
     */
    public int deleteAssetBrandById(Long id);

    /**
     * 批量删除品牌
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssetBrandByIds(Long[] ids);
}
