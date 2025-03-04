package com.ruoyi.triagle.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.triagle.domain.Triangle;
import com.ruoyi.triagle.domain.TriangleVo;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TriangularController
 * Package: com.ruoyi.system.controller
 * Description:
 *
 * @Author iuuani
 * @Create 2024/3/25 12:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/triangle")
public class TriangularController extends BaseController {
    @PostMapping
    public AjaxResult triangular(@RequestBody TriangleVo lite) {
        try {
            if(lite.getSideA() != (int) lite.getSideA()){
                return AjaxResult.error("A边不为整数");
            }
            if(lite.getSideB() != (int) lite.getSideB()){
                return AjaxResult.error("B边不为整数");
            }
            /*if(lite.getSideC() != (int) lite.getSideC()){
                return AjaxResult.error("C边不为整数");
            }*/
            Triangle triangle = new Triangle((int) lite.getSideA(), (int) lite.getSideB(), (int) lite.getSideC());
            Map<String,Object> data = new HashMap<>();
            data.put("type", triangle.toString());
            data.put("area", triangle.calcArea());
            data.put("circumference", triangle.calcCircumference());
            return AjaxResult.success(data);
        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }

    }

}

