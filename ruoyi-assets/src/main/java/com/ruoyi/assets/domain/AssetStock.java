package com.ruoyi.assets.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存清单对象 asset_stock
 * 
 * @author boger
 * @date 2025-05-16
 */
public class AssetStock extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 资产代码 */
    @Excel(name = "资产代码")
    private String code;

    /** 资产名称 */
    @Excel(name = "资产名称")
    private String name;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** 供应商 */
    @Excel(name = "供应商")
    private Long supplier;

    /** 存放地点 */
    @Excel(name = "存放地点")
    private Long location;

    /** 品牌 */
    @Excel(name = "品牌")
    private Long brand;

    /** 取得方式 */
    @Excel(name = "取得方式")
    private Long method;

    /** 入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryTime;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 备注 */
    @Excel(name = "备注")
    private String descript;

    /** 图片 */
    @Excel(name = "图片")
    private String picture;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setSupplier(Long supplier) 
    {
        this.supplier = supplier;
    }

    public Long getSupplier() 
    {
        return supplier;
    }
    public void setLocation(Long location) 
    {
        this.location = location;
    }

    public Long getLocation() 
    {
        return location;
    }
    public void setBrand(Long brand) 
    {
        this.brand = brand;
    }

    public Long getBrand() 
    {
        return brand;
    }
    public void setMethod(Long method) 
    {
        this.method = method;
    }

    public Long getMethod() 
    {
        return method;
    }
    public void setEntryTime(Date entryTime) 
    {
        this.entryTime = entryTime;
    }

    public Date getEntryTime() 
    {
        return entryTime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setDescript(String descript) 
    {
        this.descript = descript;
    }

    public String getDescript() 
    {
        return descript;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("type", getType())
            .append("supplier", getSupplier())
            .append("location", getLocation())
            .append("brand", getBrand())
            .append("method", getMethod())
            .append("entryTime", getEntryTime())
            .append("status", getStatus())
            .append("descript", getDescript())
            .append("picture", getPicture())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
