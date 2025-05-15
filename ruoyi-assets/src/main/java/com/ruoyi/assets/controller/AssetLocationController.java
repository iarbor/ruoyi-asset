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
import com.ruoyi.assets.domain.AssetLocation;
import com.ruoyi.assets.service.IAssetLocationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 存放地点Controller
 * 
 * @author boger
 * @date 2025-05-14
 */
@RestController
@RequestMapping("/assets/location")
public class AssetLocationController extends BaseController
{
    @Autowired
    private IAssetLocationService assetLocationService;

    /**
     * 查询存放地点列表
     */
    @PreAuthorize("@ss.hasPermi('assets:location:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetLocation assetLocation)
    {
        startPage();
        List<AssetLocation> list = assetLocationService.selectAssetLocationList(assetLocation);
        return getDataTable(list);
    }

    /**
     * 导出存放地点列表
     */
    @PreAuthorize("@ss.hasPermi('assets:location:export')")
    @Log(title = "存放地点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssetLocation assetLocation)
    {
        List<AssetLocation> list = assetLocationService.selectAssetLocationList(assetLocation);
        ExcelUtil<AssetLocation> util = new ExcelUtil<AssetLocation>(AssetLocation.class);
        util.exportExcel(response, list, "存放地点数据");
    }

    /**
     * 获取存放地点详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:location:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(assetLocationService.selectAssetLocationById(id));
    }

    /**
     * 新增存放地点
     */
    @PreAuthorize("@ss.hasPermi('assets:location:add')")
    @Log(title = "存放地点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetLocation assetLocation)
    {
        return toAjax(assetLocationService.insertAssetLocation(assetLocation));
    }

    /**
     * 修改存放地点
     */
    @PreAuthorize("@ss.hasPermi('assets:location:edit')")
    @Log(title = "存放地点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetLocation assetLocation)
    {
        return toAjax(assetLocationService.updateAssetLocation(assetLocation));
    }

    /**
     * 删除存放地点
     */
    @PreAuthorize("@ss.hasPermi('assets:location:remove')")
    @Log(title = "存放地点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetLocationService.deleteAssetLocationByIds(ids));
    }
}
