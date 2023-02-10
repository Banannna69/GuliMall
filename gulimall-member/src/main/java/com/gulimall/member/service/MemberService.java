package com.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.common.utils.PageUtils;
import com.gulimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author Banana69
 * @email junminn@126.com
 * @date 2023-02-10 22:29:13
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

