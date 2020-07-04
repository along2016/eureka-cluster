package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-01
 */
@Data
@TableName("t_user")
@ApiModel(value = "User",description = "用户信息表")
public class User {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value="",name="id")
    private String id;

    @TableField
    @ApiModelProperty(value="",name="name")
    private String name;

    @TableField
    @ApiModelProperty(value="",name="age")
    private Integer age;

    @TableField
    @ApiModelProperty(value="",name="mobile")
    private String mobile;

}
