package com.ruoyi.assets.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产流转对象 asset_transfer
 * 
 * @author boger
 * @date 2025-05-16
 */
public class AssetTransfer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 资产编码 */
    @Excel(name = "资产编码")
    private String assetsId;

    /** 资产名称 */
    @Excel(name = "资产名称")
    private String name;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    /** 部门id */
    @Excel(name = "部门id")
    private Long dept;

    /** 业务时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "业务时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bizTime;

    /** 业务类型(借用或归还) */
    @Excel(name = "业务类型(借用或归还)")
    private Long bizType;

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
    public void setAssetsId(String assetsId) 
    {
        this.assetsId = assetsId;
    }

    public String getAssetsId() 
    {
        return assetsId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setDept(Long dept) 
    {
        this.dept = dept;
    }

    public Long getDept() 
    {
        return dept;
    }
    public void setBizTime(Date bizTime) 
    {
        this.bizTime = bizTime;
    }

    public Date getBizTime() 
    {
        return bizTime;
    }
    public void setBizType(Long bizType) 
    {
        this.bizType = bizType;
    }

    public Long getBizType() 
    {
        return bizType;
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
            .append("assetsId", getAssetsId())
            .append("name", getName())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("dept", getDept())
            .append("bizTime", getBizTime())
            .append("bizType", getBizType())
            .append("descript", getDescript())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
