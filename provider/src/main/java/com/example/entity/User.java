package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-10
 */
@Data
//@Accessors(chain = true)
@TableName("t_user")
@ApiModel(value = "User",description = "用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

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
