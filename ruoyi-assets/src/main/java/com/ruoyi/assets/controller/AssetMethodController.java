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
import com.ruoyi.assets.domain.AssetMethod;
import com.ruoyi.assets.service.IAssetMethodService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 取得方式Controller
 * 
 * @author boger
 * @date 2025-03-04
 */
@RestController
@RequestMapping("/assets/method")
public class AssetMethodController extends BaseController
{
    @Autowired
    private IAssetMethodService assetMethodService;

    /**
     * 查询取得方式列表
     */
    @PreAuthorize("@ss.hasPermi('assets:method:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetMethod assetMethod)
    {
        startPage();
        List<AssetMethod> list = assetMethodService.selectAssetMethodList(assetMethod);
        return getDataTable(list);
    }

    /**
     * 导出取得方式列表
     */
    @PreAuthorize("@ss.hasPermi('assets:method:export')")
    @Log(title = "取得方式", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssetMethod assetMethod)
    {
        List<AssetMethod> list = assetMethodService.selectAssetMethodList(assetMethod);
        ExcelUtil<AssetMethod> util = new ExcelUtil<AssetMethod>(AssetMethod.class);
        util.exportExcel(response, list, "取得方式数据");
    }

    /**
     * 获取取得方式详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:method:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(assetMethodService.selectAssetMethodById(id));
    }

    /**
     * 新增取得方式
     */
    @PreAuthorize("@ss.hasPermi('assets:method:add')")
    @Log(title = "取得方式", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetMethod assetMethod)
    {
        return toAjax(assetMethodService.insertAssetMethod(assetMethod));
    }

    /**
     * 修改取得方式
     */
    @PreAuthorize("@ss.hasPermi('assets:method:edit')")
    @Log(title = "取得方式", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetMethod assetMethod)
    {
        return toAjax(assetMethodService.updateAssetMethod(assetMethod));
    }

    /**
     * 删除取得方式
     */
    @PreAuthorize("@ss.hasPermi('assets:method:remove')")
    @Log(title = "取得方式", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetMethodService.deleteAssetMethodByIds(ids));
    }
}
