package com.ruoyi.assets.controller;

import com.ruoyi.assets.service.IPersonDeptService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 人员选择Controller
 * 
 * @author boger
 * @date 2025-05-19
 */
@RestController
@RequestMapping("/assets/person")
public class UserDeptController extends BaseController
{
    @Autowired
    private IPersonDeptService personDeptService;

    /**
     * 查询资产流转列表
     */

    @GetMapping("/list")
    public AjaxResult getDeptAndUserList() {
        return success(personDeptService.getDeptAndUserList());
    }

    /**
     * 导出资产流转列表
     */

    @GetMapping("/listTree")
    public AjaxResult getDeptAndUserTreeData()
    {
        return success(personDeptService.getDeptAndUserTreeData());
    }



}
