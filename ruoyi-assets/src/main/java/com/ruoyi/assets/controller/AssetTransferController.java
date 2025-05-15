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
import com.ruoyi.assets.domain.AssetTransfer;
import com.ruoyi.assets.service.IAssetTransferService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产流转Controller
 * 
 * @author boger
 * @date 2025-05-16
 */
@RestController
@RequestMapping("/assets/transfer")
public class AssetTransferController extends BaseController
{
    @Autowired
    private IAssetTransferService assetTransferService;

    /**
     * 查询资产流转列表
     */
    @PreAuthorize("@ss.hasPermi('assets:transfer:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetTransfer assetTransfer)
    {
        startPage();
        List<AssetTransfer> list = assetTransferService.selectAssetTransferList(assetTransfer);
        return getDataTable(list);
    }

    /**
     * 导出资产流转列表
     */
    @PreAuthorize("@ss.hasPermi('assets:transfer:export')")
    @Log(title = "资产流转", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssetTransfer assetTransfer)
    {
        List<AssetTransfer> list = assetTransferService.selectAssetTransferList(assetTransfer);
        ExcelUtil<AssetTransfer> util = new ExcelUtil<AssetTransfer>(AssetTransfer.class);
        util.exportExcel(response, list, "资产流转数据");
    }

    /**
     * 获取资产流转详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:transfer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(assetTransferService.selectAssetTransferById(id));
    }

    /**
     * 新增资产流转
     */
    @PreAuthorize("@ss.hasPermi('assets:transfer:add')")
    @Log(title = "资产流转", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetTransfer assetTransfer)
    {
        return toAjax(assetTransferService.insertAssetTransfer(assetTransfer));
    }

    /**
     * 修改资产流转
     */
    @PreAuthorize("@ss.hasPermi('assets:transfer:edit')")
    @Log(title = "资产流转", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetTransfer assetTransfer)
    {
        return toAjax(assetTransferService.updateAssetTransfer(assetTransfer));
    }

    /**
     * 删除资产流转
     */
    @PreAuthorize("@ss.hasPermi('assets:transfer:remove')")
    @Log(title = "资产流转", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetTransferService.deleteAssetTransferByIds(ids));
    }
}
