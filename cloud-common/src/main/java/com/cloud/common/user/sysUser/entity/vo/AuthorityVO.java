package com.cloud.common.user.sysUser.entity.vo;

import com.cloud.common.auth.entity.IAuthority;
import com.cloud.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

public class AuthorityVO extends BaseEntity implements IAuthority {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "角色名",
            name = "name",
            example = "普通用户"
    )
    private String name;
    @ApiModelProperty(
            value = "角色码",
            name = "authority",
            example = "ROLE_USER"
    )
    private String authority;
    @ApiModelProperty(
            value = "描述",
            name = "description"
    )
    private String description;
    @ApiModelProperty(
            value = "等级",
            name = "level"
    )
    private Integer level;
    @ApiModelProperty(
            value = "状态",
            name = "status"
    )
    private String status;
    @ApiModelProperty(
            value = "子系统标识",
            name = "system_name"
    )
    private String systemName;

    public AuthorityVO() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public Integer getLevel() {
        return this.level;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSystemName() {
        return this.systemName;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AuthorityVO)) {
            return false;
        } else {
            AuthorityVO other = (AuthorityVO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$authority = this.getAuthority();
                Object other$authority = other.getAuthority();
                if (this$authority == null) {
                    if (other$authority != null) {
                        return false;
                    }
                } else if (!this$authority.equals(other$authority)) {
                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                label62: {
                    Object this$level = this.getLevel();
                    Object other$level = other.getLevel();
                    if (this$level == null) {
                        if (other$level == null) {
                            break label62;
                        }
                    } else if (this$level.equals(other$level)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label55;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label55;
                    }

                    return false;
                }

                Object this$systemName = this.getSystemName();
                Object other$systemName = other.getSystemName();
                if (this$systemName == null) {
                    if (other$systemName != null) {
                        return false;
                    }
                } else if (!this$systemName.equals(other$systemName)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof AuthorityVO;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $authority = this.getAuthority();
        result = result * 59 + ($authority == null ? 43 : $authority.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        Object $level = this.getLevel();
        result = result * 59 + ($level == null ? 43 : $level.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $systemName = this.getSystemName();
        result = result * 59 + ($systemName == null ? 43 : $systemName.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AuthorityVO(name=" + this.getName() + ", authority=" + this.getAuthority() + ", description=" + this.getDescription() + ", level=" + this.getLevel() + ", status=" + this.getStatus() + ", systemName=" + this.getSystemName() + ")";
    }
}
