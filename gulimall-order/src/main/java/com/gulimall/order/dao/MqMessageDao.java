package com.gulimall.order.dao;

import com.gulimall.order.entity.MqMessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author Banana69
 * @email junminn@126.com
 * @date 2023-02-10 22:55:37
 */
@Mapper
public interface MqMessageDao extends BaseMapper<MqMessageEntity> {
	
}
