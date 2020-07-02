package com.cloud.common.user.sysJob.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.common.base.entity.BaseEntity;
import com.cloud.common.user.sysOffice.entity.vo.SysOfficeVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@TableName("sys_job")
@ApiModel(
        value = "SysJobVO",
        description = "岗位信息"
)
public class SysJobVO extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "角色名",
            name = "name"
    )
    private String name;
    @ApiModelProperty(
            value = "编码",
            name = "code"
    )
    private String code;
    @TableField("office_id")
    @ApiModelProperty(
            value = "机构ID",
            name = "officeId"
    )
    private String officeId;
    @TableField(
            exist = false
    )
    @ApiModelProperty(
            value = "机构",
            name = "office"
    )
    private SysOfficeVO office;
    @TableField("data_rule")
    @ApiModelProperty(
            value = "数据规则",
            name = "dataRule"
    )
    private int dataRule;
    @ApiModelProperty(
            value = "描述",
            name = "description"
    )
    private String description;
    @ApiModelProperty(
            value = "状态",
            name = "status"
    )
    private String status;
    @ApiModelProperty(
            value = "备用1",
            name = "text1"
    )
    private String text1;
    @ApiModelProperty(
            value = "备用2",
            name = "text2"
    )
    private String text2;

    public SysJobVO() {
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public String getOfficeId() {
        return this.officeId;
    }

    public SysOfficeVO getOffice() {
        return this.office;
    }

    public int getDataRule() {
        return this.dataRule;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatus() {
        return this.status;
    }

    public String getText1() {
        return this.text1;
    }

    public String getText2() {
        return this.text2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public void setOffice(SysOfficeVO office) {
        this.office = office;
    }

    public void setDataRule(int dataRule) {
        this.dataRule = dataRule;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    @Override
    public String toString() {
        return "SysJobVO(name=" + this.getName() + ", code=" + this.getCode() + ", officeId=" + this.getOfficeId() + ", office=" + this.getOffice() + ", dataRule=" + this.getDataRule() + ", description=" + this.getDescription() + ", status=" + this.getStatus() + ", text1=" + this.getText1() + ", text2=" + this.getText2() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SysJobVO)) {
            return false;
        } else {
            SysJobVO other = (SysJobVO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else {
                label113: {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label113;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label113;
                    }

                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                Object this$officeId = this.getOfficeId();
                Object other$officeId = other.getOfficeId();
                if (this$officeId == null) {
                    if (other$officeId != null) {
                        return false;
                    }
                } else if (!this$officeId.equals(other$officeId)) {
                    return false;
                }

                label92: {
                    Object this$office = this.getOffice();
                    Object other$office = other.getOffice();
                    if (this$office == null) {
                        if (other$office == null) {
                            break label92;
                        }
                    } else if (this$office.equals(other$office)) {
                        break label92;
                    }

                    return false;
                }

                if (this.getDataRule() != other.getDataRule()) {
                    return false;
                } else {
                    Object this$description = this.getDescription();
                    Object other$description = other.getDescription();
                    if (this$description == null) {
                        if (other$description != null) {
                            return false;
                        }
                    } else if (!this$description.equals(other$description)) {
                        return false;
                    }

                    label77: {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null) {
                            if (other$status == null) {
                                break label77;
                            }
                        } else if (this$status.equals(other$status)) {
                            break label77;
                        }

                        return false;
                    }

                    label70: {
                        Object this$text1 = this.getText1();
                        Object other$text1 = other.getText1();
                        if (this$text1 == null) {
                            if (other$text1 == null) {
                                break label70;
                            }
                        } else if (this$text1.equals(other$text1)) {
                            break label70;
                        }

                        return false;
                    }

                    Object this$text2 = this.getText2();
                    Object other$text2 = other.getText2();
                    if (this$text2 == null) {
                        if (other$text2 != null) {
                            return false;
                        }
                    } else if (!this$text2.equals(other$text2)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof SysJobVO;
    }


}
