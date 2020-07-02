package com.cloud.common.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "ID",
            name = "id"
    )
    private Long id;
    @TableField("remarks")
    @ApiModelProperty(
            value = "备注信息",
            name = "remarks"
    )
    private String remarks;

    public BaseEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseEntity)) {
            return false;
        } else {
            BaseEntity other = (BaseEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$remarks = this.getRemarks();
                Object other$remarks = other.getRemarks();
                if (this$remarks == null) {
                    if (other$remarks != null) {
                        return false;
                    }
                } else if (!this$remarks.equals(other$remarks)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseEntity;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $remarks = this.getRemarks();
        result = result * 59 + ($remarks == null ? 43 : $remarks.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BaseEntity(id=" + this.getId() + ", remarks=" + this.getRemarks() + ")";
    }
}
