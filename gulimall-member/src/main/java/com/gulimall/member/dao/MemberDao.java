package com.gulimall.member.dao;

import com.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author Banana69
 * @email junminn@126.com
 * @date 2023-02-10 22:29:13
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
