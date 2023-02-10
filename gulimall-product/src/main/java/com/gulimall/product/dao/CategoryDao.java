package com.gulimall.product.dao;

import com.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author Banana69
 * @email junminn@126.com
 * @date 2023-02-10 20:55:43
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
