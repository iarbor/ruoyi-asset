package com.ruoyi.assets.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 存放地点对象 asset_location
 * 
 * @author boger
 * @date 2025-05-14
 */
public class AssetLocation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 地点名称 */
    @Excel(name = "地点名称")
    private String name;

    /** 地点代码 */
    @Excel(name = "地点代码")
    private String code;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 备注 */
    @Excel(name = "备注")
    private String descript;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("code", getCode())
            .append("type", getType())
            .append("status", getStatus())
            .append("descript", getDescript())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
