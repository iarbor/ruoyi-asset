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
import com.ruoyi.assets.domain.AssetPutStorage;
import com.ruoyi.assets.service.IAssetPutStorageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 入库Controller
 * 
 * @author ruoyi
 * @date 2025-04-20
 */
@RestController
@RequestMapping("/assets/storage")
public class AssetPutStorageController extends BaseController
{
    @Autowired
    private IAssetPutStorageService assetPutStorageService;

    /**
     * 查询入库列表
     */
    @PreAuthorize("@ss.hasPermi('assets:storage:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetPutStorage assetPutStorage)
    {
        startPage();
        List<AssetPutStorage> list = assetPutStorageService.selectAssetPutStorageList(assetPutStorage);
        return getDataTable(list);
    }

    /**
     * 导出入库列表
     */
    @PreAuthorize("@ss.hasPermi('assets:storage:export')")
    @Log(title = "入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssetPutStorage assetPutStorage)
    {
        List<AssetPutStorage> list = assetPutStorageService.selectAssetPutStorageList(assetPutStorage);
        ExcelUtil<AssetPutStorage> util = new ExcelUtil<AssetPutStorage>(AssetPutStorage.class);
        util.exportExcel(response, list, "入库数据");
    }

    /**
     * 获取入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:storage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(assetPutStorageService.selectAssetPutStorageById(id));
    }

    /**
     * 新增入库
     */
    @PreAuthorize("@ss.hasPermi('assets:storage:add')")
    @Log(title = "入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetPutStorage assetPutStorage)
    {
        return toAjax(assetPutStorageService.insertAssetPutStorage(assetPutStorage));
    }

    /**
     * 修改入库
     */
    @PreAuthorize("@ss.hasPermi('assets:storage:edit')")
    @Log(title = "入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetPutStorage assetPutStorage)
    {
        return toAjax(assetPutStorageService.updateAssetPutStorage(assetPutStorage));
    }

    /**
     * 删除入库
     */
    @PreAuthorize("@ss.hasPermi('assets:storage:remove')")
    @Log(title = "入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetPutStorageService.deleteAssetPutStorageByIds(ids));
    }
}
