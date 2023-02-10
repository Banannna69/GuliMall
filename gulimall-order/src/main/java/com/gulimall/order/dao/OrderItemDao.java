package com.gulimall.order.dao;

import com.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author Banana69
 * @email junminn@126.com
 * @date 2023-02-10 22:55:37
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
