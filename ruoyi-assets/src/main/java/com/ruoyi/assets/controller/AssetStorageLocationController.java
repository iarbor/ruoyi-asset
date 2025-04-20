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
import com.ruoyi.assets.domain.AssetStorageLocation;
import com.ruoyi.assets.service.IAssetStorageLocationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 存放地点Controller
 * 
 * @author ruoyi
 * @date 2025-04-20
 */
@RestController
@RequestMapping("/assets/location")
public class AssetStorageLocationController extends BaseController
{
    @Autowired
    private IAssetStorageLocationService assetStorageLocationService;

    /**
     * 查询存放地点列表
     */
    @PreAuthorize("@ss.hasPermi('assets:location:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetStorageLocation assetStorageLocation)
    {
        startPage();
        List<AssetStorageLocation> list = assetStorageLocationService.selectAssetStorageLocationList(assetStorageLocation);
        return getDataTable(list);
    }

    /**
     * 导出存放地点列表
     */
    @PreAuthorize("@ss.hasPermi('assets:location:export')")
    @Log(title = "存放地点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssetStorageLocation assetStorageLocation)
    {
        List<AssetStorageLocation> list = assetStorageLocationService.selectAssetStorageLocationList(assetStorageLocation);
        ExcelUtil<AssetStorageLocation> util = new ExcelUtil<AssetStorageLocation>(AssetStorageLocation.class);
        util.exportExcel(response, list, "存放地点数据");
    }

    /**
     * 获取存放地点详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:location:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(assetStorageLocationService.selectAssetStorageLocationById(id));
    }

    /**
     * 新增存放地点
     */
    @PreAuthorize("@ss.hasPermi('assets:location:add')")
    @Log(title = "存放地点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetStorageLocation assetStorageLocation)
    {
        return toAjax(assetStorageLocationService.insertAssetStorageLocation(assetStorageLocation));
    }

    /**
     * 修改存放地点
     */
    @PreAuthorize("@ss.hasPermi('assets:location:edit')")
    @Log(title = "存放地点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetStorageLocation assetStorageLocation)
    {
        return toAjax(assetStorageLocationService.updateAssetStorageLocation(assetStorageLocation));
    }

    /**
     * 删除存放地点
     */
    @PreAuthorize("@ss.hasPermi('assets:location:remove')")
    @Log(title = "存放地点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetStorageLocationService.deleteAssetStorageLocationByIds(ids));
    }

    /**
     * 查询下拉框中的存放地点的值
     */
    @GetMapping("/selectPlaceData")
    public TableDataInfo selectPlaceData()
    {
        AssetStorageLocation assetStorageLocation = new AssetStorageLocation();
        List<AssetStorageLocation> list = assetStorageLocationService.selectAssetStorageLocationList(assetStorageLocation);
        return getDataTable(list);
    }
}
