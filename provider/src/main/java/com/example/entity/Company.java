package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 公司信息
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-06
 */
@Data
@TableName("t_company")
@ApiModel(value = "Company",description = "公司信息")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司名称
     */
    @TableField
    @ApiModelProperty(value="公司名称",name="name")
    private String name;

    /**
     * 公司地址
     */
    @TableField
    @ApiModelProperty(value="公司地址",name="address")
    private String address;

}
