package com.ruoyi.assets.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.lang.tree.Tree;
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
import com.ruoyi.assets.domain.AssetStock;
import com.ruoyi.assets.service.IAssetStockService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存清单Controller
 * 
 * @author boger
 * @date 2025-05-16
 */
@RestController
@RequestMapping("/assets/stock")
public class AssetStockController extends BaseController
{
    @Autowired
    private IAssetStockService assetStockService;

    /**
     * 查询库存清单列表
     */
    @PreAuthorize("@ss.hasPermi('assets:stock:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetStock assetStock)
    {
        startPage();
        List<AssetStock> list = assetStockService.selectAssetStockList(assetStock);
        return getDataTable(list);
    }

    /**
     * 导出库存清单列表
     */
    @PreAuthorize("@ss.hasPermi('assets:stock:export')")
    @Log(title = "库存清单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssetStock assetStock)
    {
        List<AssetStock> list = assetStockService.selectAssetStockList(assetStock);
        ExcelUtil<AssetStock> util = new ExcelUtil<AssetStock>(AssetStock.class);
        util.exportExcel(response, list, "库存清单数据");
    }

    /**
     * 获取库存清单详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:stock:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(assetStockService.selectAssetStockById(id));
    }

    /**
     * 新增库存清单
     */
    @PreAuthorize("@ss.hasPermi('assets:stock:add')")
    @Log(title = "库存清单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetStock assetStock)
    {
        return toAjax(assetStockService.insertAssetStock(assetStock));
    }

    /**
     * 修改库存清单
     */
    @PreAuthorize("@ss.hasPermi('assets:stock:edit')")
    @Log(title = "库存清单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetStock assetStock)
    {
        return toAjax(assetStockService.updateAssetStock(assetStock));
    }

    /**
     * 删除库存清单
     */
    @PreAuthorize("@ss.hasPermi('assets:stock:remove')")
    @Log(title = "库存清单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetStockService.deleteAssetStockByIds(ids));
    }

    /**
     * 查询可领用库存清单列表
     */
    @PreAuthorize("@ss.hasPermi('assets:stock:list')")
    @GetMapping("/list4Borrow")
    public AjaxResult list4Borrow()
    {
        AssetStock assetStock = new AssetStock();
        assetStock.setStatus(1L);
        List<Tree<String>> list = assetStockService.getCategoryAndStockTreeData(assetStock);
        AjaxResult r = success(list);
        return r;
    }

    /**
     * 查询可归还库存清单列表
     */
    @PreAuthorize("@ss.hasPermi('assets:stock:list')")
    @GetMapping("/list4Return")
    public AjaxResult list4Return()
    {
        AssetStock assetStock = new AssetStock();
        assetStock.setStatus(2L);
        List<Tree<String>> list = assetStockService.getCategoryAndStockTreeData(assetStock);
        return success(list);
    }
}
