package com.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.gulimall.common.valid.AddGroup;
import com.gulimall.common.valid.ListValue;
import com.gulimall.common.valid.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author Banana69
 * @email junminn@126.com
 * @date 2023-02-10 20:55:43
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@NotNull(message = "修改必须指定品牌ID",groups ={UpdateGroup.class} )
	@Null(message = "新增不能指定品牌ID",groups = {AddGroup.class})
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空",groups = {UpdateGroup.class, AddGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@URL(message = "Logo必须是合法的URL地址",groups = {UpdateGroup.class, AddGroup.class})
	@NotEmpty(groups = {AddGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@ListValue(vals = {0,1},groups = {AddGroup.class, UpdateGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@Pattern(regexp = "^[a-zA-z]$",message = "检索首字母必须为字母",groups = {UpdateGroup.class, AddGroup.class})
	@NotNull(groups = {AddGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@Min(value=0,message = "排序必须大于等于0",groups = {UpdateGroup.class, AddGroup.class})
	@NotNull(groups = {AddGroup.class})
	private Integer sort;

}
