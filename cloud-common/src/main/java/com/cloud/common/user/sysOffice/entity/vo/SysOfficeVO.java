package com.cloud.common.user.sysOffice.entity.vo;

import com.cloud.common.base.entity.BaseEntity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Objects;

@TableName("sys_office")
@ApiModel(
        value = "SysOfficeVO",
        description = "机构信息"
)
public class SysOfficeVO extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @TableField("parent_id")
    @ApiModelProperty(
            value = "父级编号",
            name = "parentId"
    )
    private String parentId;
    @TableField(
            exist = false
    )
    @ApiModelProperty(
            value = "父级名称",
            name = "parentName"
    )
    private String parentName;
    @TableField("parent_ids")
    @ApiModelProperty(
            value = "所有父级编号",
            name = "parentIds"
    )
    private String parentIds;
    @TableField
    @ApiModelProperty(
            value = "名称",
            name = "name"
    )
    private String name;
    @TableField
    @ApiModelProperty(
            value = "排序",
            name = "sort"
    )
    private BigDecimal sort;
    @TableField
    @ApiModelProperty(
            value = "机构编码",
            name = "code"
    )
    private String code;
    @TableField
    @ApiModelProperty(
            value = "机构类型",
            name = "type"
    )
    private String type;
    @TableField
    @ApiModelProperty(
            value = "机构等级",
            name = "grade"
    )
    private String grade;
    @TableField
    @ApiModelProperty(
            value = "联系地址",
            name = "address"
    )
    private String address;
    @TableField("zip_code")
    @ApiModelProperty(
            value = "邮政编码",
            name = "zipCode"
    )
    private String zipCode;
    @TableField
    @ApiModelProperty(
            value = "负责人",
            name = "master"
    )
    private String master;
    @TableField
    @ApiModelProperty(
            value = "电话",
            name = "phone"
    )
    private String phone;
    @TableField
    @ApiModelProperty(
            value = "传真",
            name = "fax"
    )
    private String fax;
    @TableField
    @ApiModelProperty(
            value = "邮箱",
            name = "email"
    )
    private String email;
    @TableField("is_enable")
    @ApiModelProperty(
            value = "是否启用",
            name = "isEnable"
    )
    private String isEnable;
    @TableField
    @ApiModelProperty(
            value = "备用字段1",
            name = "text1"
    )
    private String text1;
    @TableField
    @ApiModelProperty(
            value = "备用字段2",
            name = "text2"
    )
    private String text2;
    @ApiModelProperty(
            value = "区域Id",
            name = "regionId"
    )
    private String regionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof SysOfficeVO)) {
            return false;
        } else if (!super.equals(o)) {
            return false;
        } else {
            SysOfficeVO officeVO = (SysOfficeVO)o;
            return Objects.equals(this.getId(), officeVO.getId()) && Objects.equals(this.getName(), officeVO.getName());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{super.hashCode(), this.getId(), this.getName()});
    }

    public SysOfficeVO() {
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getParentName() {
        return this.parentName;
    }

    public String getParentIds() {
        return this.parentIds;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getSort() {
        return this.sort;
    }

    public String getCode() {
        return this.code;
    }

    public String getType() {
        return this.type;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getAddress() {
        return this.address;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String getMaster() {
        return this.master;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getFax() {
        return this.fax;
    }

    public String getEmail() {
        return this.email;
    }

    public String getIsEnable() {
        return this.isEnable;
    }

    public String getText1() {
        return this.text1;
    }

    public String getText2() {
        return this.text2;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "SysOfficeVO(parentId=" + this.getParentId() + ", parentName=" + this.getParentName() + ", parentIds=" + this.getParentIds() + ", name=" + this.getName() + ", sort=" + this.getSort() + ", code=" + this.getCode() + ", type=" + this.getType() + ", grade=" + this.getGrade() + ", address=" + this.getAddress() + ", zipCode=" + this.getZipCode() + ", master=" + this.getMaster() + ", phone=" + this.getPhone() + ", fax=" + this.getFax() + ", email=" + this.getEmail() + ", isEnable=" + this.getIsEnable() + ", text1=" + this.getText1() + ", text2=" + this.getText2() + ", regionId=" + this.getRegionId() + ")";
    }
}
