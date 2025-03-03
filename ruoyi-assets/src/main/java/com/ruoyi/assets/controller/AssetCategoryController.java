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
import com.ruoyi.assets.domain.AssetCategory;
import com.ruoyi.assets.service.IAssetCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产类别Controller
 * 
 * @author ruoyi
 * @date 2025-03-03
 */
@RestController
@RequestMapping("/assets/category")
public class AssetCategoryController extends BaseController
{
    @Autowired
    private IAssetCategoryService assetCategoryService;

    /**
     * 查询资产类别列表
     */
    @PreAuthorize("@ss.hasPermi('assets:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetCategory assetCategory)
    {
        startPage();
        List<AssetCategory> list = assetCategoryService.selectAssetCategoryList(assetCategory);
        return getDataTable(list);
    }

    /**
     * 导出资产类别列表
     */
    @PreAuthorize("@ss.hasPermi('assets:category:export')")
    @Log(title = "资产类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssetCategory assetCategory)
    {
        List<AssetCategory> list = assetCategoryService.selectAssetCategoryList(assetCategory);
        ExcelUtil<AssetCategory> util = new ExcelUtil<AssetCategory>(AssetCategory.class);
        util.exportExcel(response, list, "资产类别数据");
    }

    /**
     * 获取资产类别详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(assetCategoryService.selectAssetCategoryById(id));
    }

    /**
     * 新增资产类别
     */
    @PreAuthorize("@ss.hasPermi('assets:category:add')")
    @Log(title = "资产类别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetCategory assetCategory)
    {
        return toAjax(assetCategoryService.insertAssetCategory(assetCategory));
    }

    /**
     * 修改资产类别
     */
    @PreAuthorize("@ss.hasPermi('assets:category:edit')")
    @Log(title = "资产类别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetCategory assetCategory)
    {
        return toAjax(assetCategoryService.updateAssetCategory(assetCategory));
    }

    /**
     * 删除资产类别
     */
    @PreAuthorize("@ss.hasPermi('assets:category:remove')")
    @Log(title = "资产类别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetCategoryService.deleteAssetCategoryByIds(ids));
    }
}
