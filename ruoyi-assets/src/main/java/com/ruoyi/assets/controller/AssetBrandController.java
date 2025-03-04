package com.ruoyi.assets.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.assets.domain.AssetBrand;
import com.ruoyi.assets.service.IAssetBrandService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品牌Controller
 * 
 * @author boger
 * @date 2025-03-04
 */
@RestController
@RequestMapping("/assets/brand")
public class AssetBrandController extends BaseController
{
    @Autowired
    private IAssetBrandService assetBrandService;

    /**
     * 查询品牌列表
     */
    @PreAuthorize("@ss.hasPermi('assets:brand:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetBrand assetBrand)
    {
        startPage();
        List<AssetBrand> list = assetBrandService.selectAssetBrandList(assetBrand);
        return getDataTable(list);
    }

    /**
     * 导出品牌列表
     */
    @PreAuthorize("@ss.hasPermi('assets:brand:export')")
    @Log(title = "品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssetBrand assetBrand)
    {
        List<AssetBrand> list = assetBrandService.selectAssetBrandList(assetBrand);
        ExcelUtil<AssetBrand> util = new ExcelUtil<AssetBrand>(AssetBrand.class);
        util.exportExcel(response, list, "品牌数据");
    }

    /**
     * 获取品牌详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:brand:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(assetBrandService.selectAssetBrandById(id));
    }

    /**
     * 新增品牌
     */
    @PreAuthorize("@ss.hasPermi('assets:brand:add')")
    @Log(title = "品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetBrand assetBrand)
    {
        return toAjax(assetBrandService.insertAssetBrand(assetBrand));
    }

    /**
     * 修改品牌
     */
    @PreAuthorize("@ss.hasPermi('assets:brand:edit')")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetBrand assetBrand)
    {
        return toAjax(assetBrandService.updateAssetBrand(assetBrand));
    }

    /**
     * 删除品牌
     */
    @PreAuthorize("@ss.hasPermi('assets:brand:remove')")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetBrandService.deleteAssetBrandByIds(ids));
    }
}
