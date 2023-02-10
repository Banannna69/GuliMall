package com.gulimall.order.dao;

import com.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author Banana69
 * @email junminn@126.com
 * @date 2023-02-10 22:55:37
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
