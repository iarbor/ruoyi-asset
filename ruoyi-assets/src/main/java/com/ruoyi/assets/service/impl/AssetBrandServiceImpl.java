package com.ruoyi.assets.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetBrandMapper;
import com.ruoyi.assets.domain.AssetBrand;
import com.ruoyi.assets.service.IAssetBrandService;

/**
 * 品牌Service业务层处理
 * 
 * @author boger
 * @date 2025-03-04
 */
@Service
public class AssetBrandServiceImpl implements IAssetBrandService 
{
    @Autowired
    private AssetBrandMapper assetBrandMapper;

    /**
     * 查询品牌
     * 
     * @param id 品牌主键
     * @return 品牌
     */
    @Override
    public AssetBrand selectAssetBrandById(Long id)
    {
        return assetBrandMapper.selectAssetBrandById(id);
    }

    /**
     * 查询品牌列表
     * 
     * @param assetBrand 品牌
     * @return 品牌
     */
    @Override
    public List<AssetBrand> selectAssetBrandList(AssetBrand assetBrand)
    {
        return assetBrandMapper.selectAssetBrandList(assetBrand);
    }

    /**
     * 新增品牌
     * 
     * @param assetBrand 品牌
     * @return 结果
     */
    @Override
    public int insertAssetBrand(AssetBrand assetBrand)
    {
        assetBrand.setCreateTime(DateUtils.getNowDate());
        return assetBrandMapper.insertAssetBrand(assetBrand);
    }

    /**
     * 修改品牌
     * 
     * @param assetBrand 品牌
     * @return 结果
     */
    @Override
    public int updateAssetBrand(AssetBrand assetBrand)
    {
        assetBrand.setUpdateTime(DateUtils.getNowDate());
        return assetBrandMapper.updateAssetBrand(assetBrand);
    }

    /**
     * 批量删除品牌
     * 
     * @param ids 需要删除的品牌主键
     * @return 结果
     */
    @Override
    public int deleteAssetBrandByIds(Long[] ids)
    {
        return assetBrandMapper.deleteAssetBrandByIds(ids);
    }

    /**
     * 删除品牌信息
     * 
     * @param id 品牌主键
     * @return 结果
     */
    @Override
    public int deleteAssetBrandById(Long id)
    {
        return assetBrandMapper.deleteAssetBrandById(id);
    }
}
